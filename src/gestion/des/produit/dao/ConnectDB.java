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
public class ConnectDB {

    private final String User = "mls";
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
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, " erreur connexion activer le serveur ou verifier "
                        + "\nle configuration de  serveur");

            } finally {
                System.out.print("Vous avez connectés");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

        return re;
    }

    public void UpdatUser(Authentification log,int id) {

        try {
            String sql = "Update user set user='" + log + "',password='" + log + "'"
                    + "where id_user= +id";

            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//Fournisseur et client
    public void insertFornisseur(Fornisseur forn) {

        try {
            st = cnx.createStatement();
            String sql1 = "INSERT INTO `fornisseur`( `nom_prenom`, `N_telephone`, `Adresse`,`Ville`) "
                    + "VALUES ('" + forn.nom_prenom + "'," + "'" + forn.telephone + "','" + forn.adresse + "','" + forn.ville + "') ";
            st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ereur operation");
        }

    }

    public void insertClient(Client cl) {
        try {
            st = cnx.createStatement();
            String sql1 = "INSERT INTO `client`( `nom_prenom`, `N_telephone`, `Adresse`) "
                    + "VALUES ('" + cl.nom_prenom + "'," + "'" + cl.telephone + "','" + cl.adresse + "') ";
            st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ereur operation");
        }
    }

    public void AllFornisseur(JTable T) {
        try {
            st = cnx.createStatement();
            String sql = "select * from fornisseur";
            rst = (ResultSet) st.executeQuery(sql);
            int i = 0, j;

            while (rst.next()) {
                j = 0;
                T.setValueAt(rst.getInt("N_forn"), i, j);
                j++;
                T.setValueAt(rst.getString("nom_prenom").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("N_telephone").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Adresse").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Ville").toString(), i, j);
                j++;
                i++;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

    public void AllClient(JTable T) {
        try {
            st = cnx.createStatement();
            String sql = "select * from client";
            rst = (ResultSet) st.executeQuery(sql);
            int i = 0, j;
            while (rst.next()) {
                j = 0;
                T.setValueAt(rst.getInt("N_client"), i, j);
                j++;
                T.setValueAt(rst.getString("nom_prenom").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("N_telephone").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Adresse").toString(), i, j);
                j++;

                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

    public void DeleteForn(int id) {
        String sql = "DELETE FROM fornisseur WHERE N_forn=" + id;
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdatForn(int id, Fornisseur fr) {

        try {
            st = cnx.createStatement();
            String sql = "Update fornisseur set nom_prenom='" + fr.nom_prenom + "',N_telephone='" + fr.telephone + "',"
                    + "Adresse='" + fr.adresse + "'" + ",Ville='" + fr.ville + "'"
                    + " where N_forn=" + id;
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DeleteClient(int id) {
        String sql = "DELETE FROM client WHERE N_client=" + id;
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdatClient(int id, Client cl) {

        try {
            st = cnx.createStatement();
            String sql = "Update client set  nom_prenom='" + cl.nom_prenom + "',N_telephone='" + cl.telephone + "',"
                    + "Adresse='" + cl.adresse + "'"
                    + "where N_client=" + id;

            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void FindClient(JTable T, String word) {
        try {
            st = cnx.createStatement();
            String sql = "SELECT * FROM `client` WHERE nom_prenom like '" + word + "%'  ";
            rst = (ResultSet) st.executeQuery(sql);
            int i = 0, j;
            while (rst.next()) {
                j = 0;
                T.setValueAt(rst.getInt("N_client"), i, j);
                j++;
                T.setValueAt(rst.getString("nom_prenom").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("N_telephone").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Adresse").toString(), i, j);
                j++;

                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

    public void FindFornisseur(JTable T, String word, String recherche) {
        try {
            st = cnx.createStatement();
            String sql = "SELECT * FROM fornisseur WHERE " + word + " like '" + recherche + "%'  ";
            rst = (ResultSet) st.executeQuery(sql);
            int i = 0, j;
            while (rst.next()) {
                j = 0;
                T.setValueAt(rst.getInt("N_forn"), i, j);
                j++;
                T.setValueAt(rst.getString("nom_prenom").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("N_telephone").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Adresse").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Ville").toString(), i, j);
                j++;
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

}
