/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.des.produit.dao;

import gestion.des.produit.Authentification;
import gestion.des.produit.modele.Client;
import gestion.des.produit.modele.Fornisseur;
import gestion.des.produit.modele.Produits;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Aimé Lovasoa
 * 
 */
public class ConnectDBAdmin {

    private final String User = "root";
    private final String password = "";
    String ipLocal = "localhost";

    private String url = "jdbc:mysql://" + ipLocal + ":3306/gestion de produit";
    private Connection cnx;
    private Statement st, jt;
    private ResultSet rst;

    public void DeleteAllElementTab(JTable T, int column, int row) {
        int i = 0;
        int j = 0;
        while (i < row) {
            while (j <= column) {
                T.setValueAt("", i, j);
                j++;
            }
            j = 0;
            i++;
        }

    }

    public String showDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(" YYYY-MM-dd");
        return sdf.format(d);

    }

    public String showDateTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        return sdf.format(d);

    }

    public void ConnexionIntoDataBase() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK");
            try {
                cnx = DriverManager.getConnection(url, User, password);
                System.out.println("successful connexion");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDBAdmin.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, " erreur connexion activer le serveur ou verifier "
                        + "\nle configuration de  serveur");

            } finally {
                System.out.print("Vous avez connectés");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDBAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Authentification
    public int FindUser(String user, String pass) {
        int re = 0;
        try {
            st = cnx.createStatement();
            String sql = "select * from user";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {

                if (rst.getString("user").equals(user) && rst.getString("password").equals(pass)) {
                    re = 1;
                } else {
                    re = 0;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDBAdmin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

        return re;
    }
}
