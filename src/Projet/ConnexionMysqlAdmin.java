/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet;
import java.sql.*;
/**
 *
 * @author Aimé Lovasoa
 */
public class ConnexionMysqlAdmin {
    public static Connection getCon()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion de produit","root","");
            return con1;
        } catch (Exception e) 
        {
            return null;
        }
    }
    
}
