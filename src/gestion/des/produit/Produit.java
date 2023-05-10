/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.des.produit;

import Projet.ConnexionMysql;
import gestion.des.produit.dao.ConnectDB;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AmineGasa
 */
public class Produit extends javax.swing.JFrame {

    /**
     * Creates new form ProduitForm
     */
    public Produit() {
        initComponents();icon();
        table_modifier();
    }
void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().
                getResource("Cartgrill_icon-icons.com_51191.png")));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDesignation = new javax.swing.JTextField();
        jSpinnerQuantite = new javax.swing.JSpinner();
        btnAjouter = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        btnActualiser = new javax.swing.JButton();
        btnRecherche = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduits = new javax.swing.JTable();
        jTextFieldRecherche = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnProduit = new javax.swing.JLabel();

        setTitle("Produits");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldId.setEditable(false);
        jTextFieldId.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jTextFieldId.setForeground(new java.awt.Color(204, 0, 51));
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 210, 40));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel1.setText("ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel2.setText("Désignation:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jTextFieldDesignation.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jTextFieldDesignation.setForeground(new java.awt.Color(0, 102, 255));
        jTextFieldDesignation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDesignationActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldDesignation, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 210, 40));

        jSpinnerQuantite.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jPanel1.add(jSpinnerQuantite, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 210, 40));

        btnAjouter.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        btnAjouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/ajouter.png"))); // NOI18N
        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });
        jPanel1.add(btnAjouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 131, -1));

        btnModifier.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        btnModifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/User-Files-icon.png"))); // NOI18N
        btnModifier.setText("Modifier");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });
        jPanel1.add(btnModifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 160, 40));

        btnSupprimer.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        btnSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/supprimer.png"))); // NOI18N
        btnSupprimer.setText("Supprimer");
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });
        jPanel1.add(btnSupprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 160, 40));

        btnActualiser.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        btnActualiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/modifier.png"))); // NOI18N
        btnActualiser.setText("Actualiser");
        btnActualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualiserActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualiser, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, 40));

        btnRecherche.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        btnRecherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/viewmag--icone-5948-32.png"))); // NOI18N
        btnRecherche.setText("rechercher");
        btnRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercheActionPerformed(evt);
            }
        });
        jPanel1.add(btnRecherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 162, 40));

        jTableProduits.setBackground(new java.awt.Color(253, 245, 253));
        jTableProduits.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableProduits.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Désignation", "Quantité totale"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProduits.setToolTipText(""); // NOI18N
        jTableProduits.setGridColor(new java.awt.Color(255, 0, 0));
        jTableProduits.setRowMargin(2);
        jTableProduits.setSelectionBackground(new java.awt.Color(0, 51, 255));
        jTableProduits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProduitsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableProduitsMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProduits);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 61, 480, 540));

        jTextFieldRecherche.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jTextFieldRecherche.setForeground(new java.awt.Color(0, 102, 255));
        jTextFieldRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRechercheActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldRecherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 10, 120, 40));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel7.setText("Quantité:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jLabel4.setFont(new java.awt.Font("PMingLiU", 1, 48)); // NOI18N
        jLabel4.setText("PRODUITS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 240, 60));

        btnProduit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/warehouse(1).png"))); // NOI18N
        btnProduit.setToolTipText("tout concerné avec le stock");
        btnProduit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnProduit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProduitMouseClicked(evt);
            }
        });
        jPanel1.add(btnProduit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 130));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 980, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    PreparedStatement insert;
    PreparedStatement search;
    PreparedStatement count;
    
     private void table_modifier()
            {
        int c;
        try {
            Connection con = ConnexionMysql.getCon();
            insert = con.prepareStatement("SELECT * FROM produit");
            ResultSet rs = insert.executeQuery();
            ResultSetMetaData Rss = rs.getMetaData();
            c = Rss.getColumnCount();

            DefaultTableModel Df = (DefaultTableModel) jTableProduits.getModel();
            Df.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int a = 1; a < c; a++) {
                    v2.add(rs.getString("N_prod"));
                    v2.add(rs.getString("designation"));
                    v2.add(rs.getString("qte_totale"));
                }

                Df.addRow(v2);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur!");
        }

    }
            
    private void jTextFieldDesignationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDesignationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesignationActionPerformed
    ConnectDB db;
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated


    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        String design = jTextFieldDesignation.getText();
        int quantite = Integer.parseInt(jSpinnerQuantite.getValue().toString());

        try {
            if (design.equals("")) {
                JOptionPane.showMessageDialog(null, "Remplissez les champs vides!");
            } else {
                Connection con = ConnexionMysql.getCon();
                search = con.prepareStatement("SELECT * FROM produit WHERE designation = '" + design + "'");
                ResultSet rs = search.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Déjà existe dans la liste!");
                } else {
                    insert = con.prepareStatement("INSERT INTO `produit` (`designation`, `qte_totale`) VALUES(?,?)");
                    insert.setString(1, design);
                    insert.setInt(2, quantite);
                    insert.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Produit ajoutés avec succès!");
                    table_modifier();

                    jTextFieldDesignation.setText("");
                    jTextFieldDesignation.requestFocus();

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur!");
        }        
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        DefaultTableModel Df = (DefaultTableModel) jTableProduits.getModel();
        int selectedIndex = jTableProduits.getSelectedRow();

        try {
            int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
            String design = jTextFieldDesignation.getText();
            int quantite = Integer.parseInt(jSpinnerQuantite.getValue().toString());
            Connection con = ConnexionMysql.getCon();

            count = con.prepareStatement("SELECT COUNT(*) As designCount FROM produit WHERE designation = '" + design + "'");
            ResultSet resultat = count.executeQuery();
            while (resultat.next()) {
                int nombre = resultat.getInt("designCount");
                if (nombre > 1) {
                    JOptionPane.showMessageDialog(null, "Veuillez vérifier la désignation!");
                } else { 
                    insert = con.prepareStatement("UPDATE produit SET designation = ?, qte_totale= ? WHERE N_prod=?");
                    insert.setString(1, design);
                    insert.setInt(2, quantite);
                    insert.setInt(3, id);
                    insert.executeUpdate();

                    System.out.println(nombre);
                    JOptionPane.showMessageDialog(null, "Produits modifié!");
                    table_modifier();

                    jTextFieldId.setText("");
                    jTextFieldDesignation.setText("");
                    jSpinnerQuantite.setValue(0);
                    jSpinnerQuantite.requestFocus();

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur!");
        }        
    }//GEN-LAST:event_btnModifierActionPerformed

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        DefaultTableModel Df = (DefaultTableModel) jTableProduits.getModel();
        int selectedIndex = jTableProduits.getSelectedRow();

        try {
            int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());

            int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez vous supprimés", "Warning", JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_NO_OPTION) {
                Connection con = ConnexionMysql.getCon();

                insert = con.prepareStatement("DELETE FROM produit WHERE N_prod=?");

                insert.setInt(1, id);
            }

            insert.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produit supprimé!");
            table_modifier();
            jTextFieldId.setText("");
            jTextFieldDesignation.setText("");
            jSpinnerQuantite.setValue(0);
            jTextFieldDesignation.requestFocus();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de la suppression");
        }      

    }//GEN-LAST:event_btnSupprimerActionPerformed

    private void btnActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualiserActionPerformed
    table_modifier();
    }//GEN-LAST:event_btnActualiserActionPerformed

    private void btnRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechercheActionPerformed
        int c;
        String tf = jTextFieldRecherche.getText();
        try {
            Connection con = ConnexionMysql.getCon();
            insert = con.prepareStatement("SELECT * FROM produit WHERE designation LIKE '%" + tf + "%'");
            ResultSet rs = insert.executeQuery();
            ResultSetMetaData Rss = rs.getMetaData();
            c = Rss.getColumnCount();

            DefaultTableModel Df = (DefaultTableModel) jTableProduits.getModel();
            Df.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int a = 1; a < c; a++) {
                    v2.add(rs.getString("N_prod"));
                    v2.add(rs.getString("designation"));
                    v2.add(rs.getString("qte_totale"));
                }

                Df.addRow(v2);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur!");
        }
    }//GEN-LAST:event_btnRechercheActionPerformed

    private void jTableProduitsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProduitsMouseClicked

        DefaultTableModel Df = (DefaultTableModel)jTableProduits.getModel();
        int selectedIndex = jTableProduits.getSelectedRow();
        
            jTextFieldId.setText(Df.getValueAt(selectedIndex, 0).toString());
            jTextFieldDesignation.setText(Df.getValueAt(selectedIndex, 1).toString());
            jSpinnerQuantite.setValue(Integer.parseInt(Df.getValueAt(selectedIndex, 2).toString()));

    }//GEN-LAST:event_jTableProduitsMouseClicked

    private void jTextFieldRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRechercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRechercheActionPerformed

    private void jTableProduitsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProduitsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableProduitsMouseEntered

    private void btnProduitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProduitMouseClicked
        Produit sf = new Produit();
        sf.setVisible(true);
    }//GEN-LAST:event_btnProduitMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiser;
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnModifier;
    private javax.swing.JLabel btnProduit;
    private javax.swing.JButton btnRecherche;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerQuantite;
    private javax.swing.JTable jTableProduits;
    private javax.swing.JTextField jTextFieldDesignation;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldRecherche;
    // End of variables declaration//GEN-END:variables
}