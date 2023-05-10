/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.des.produit;


import Projet.ConnexionMysqlAdmin;
import gestion.des.produit.dao.ConnectDBAdmin;
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
public class AuditProduit extends javax.swing.JFrame {

    /**
     * Creates new form ProduitForm
     */
    public AuditProduit() {
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
        btnActualiser = new javax.swing.JButton();
        btnRecherche = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduits = new javax.swing.JTable();
        jTextFieldRecherche = new javax.swing.JTextField();
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

        btnActualiser.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        btnActualiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/modifier.png"))); // NOI18N
        btnActualiser.setText("Actualiser");
        btnActualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualiserActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualiser, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, 40));

        btnRecherche.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        btnRecherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/viewmag--icone-5948-32.png"))); // NOI18N
        btnRecherche.setText("rechercher");
        btnRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercheActionPerformed(evt);
            }
        });
        jPanel1.add(btnRecherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, 162, 40));

        jTableProduits.setBackground(new java.awt.Color(253, 245, 253));
        jTableProduits.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTableProduits.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTableProduits.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Désignation", "Ancien Stock", "Nouveau Stock", "Date", "Type", "Utilisateur"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProduits.setToolTipText(""); // NOI18N
        jTableProduits.setAlignmentX(1000.0F);
        jTableProduits.setGridColor(new java.awt.Color(0, 0, 0));
        jTableProduits.setRowMargin(2);
        jTableProduits.setSelectionBackground(new java.awt.Color(0, 51, 255));
        jTableProduits.setShowHorizontalLines(true);
        jTableProduits.setShowVerticalLines(true);
        jTableProduits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProduitsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableProduitsMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProduits);
        if (jTableProduits.getColumnModel().getColumnCount() > 0) {
            jTableProduits.getColumnModel().getColumn(0).setMinWidth(50);
            jTableProduits.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableProduits.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableProduits.getColumnModel().getColumn(4).setMinWidth(200);
            jTableProduits.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTableProduits.getColumnModel().getColumn(4).setMaxWidth(200);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 141, 970, 460));

        jTextFieldRecherche.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jTextFieldRecherche.setForeground(new java.awt.Color(0, 102, 255));
        jTextFieldRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRechercheActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldRecherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 120, 40));

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
            Connection con = ConnexionMysqlAdmin.getCon();
            insert = con.prepareStatement("SELECT * FROM audit_produit");
            ResultSet rs = insert.executeQuery();
            ResultSetMetaData Rss = rs.getMetaData();
            c = Rss.getColumnCount();

            DefaultTableModel Df = (DefaultTableModel) jTableProduits.getModel();
            Df.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int a = 1; a < c; a++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("designation"));
                    v2.add(rs.getString("stock_ancien"));     
                    v2.add(rs.getString("stock_nouv"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("type"));
                    v2.add(rs.getString("utilisateur"));  
                }

                Df.addRow(v2);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur!");
        }

    }
                ConnectDBAdmin db;
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated


    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void btnActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualiserActionPerformed
    table_modifier();
    jTextFieldRecherche.setText("");
    }//GEN-LAST:event_btnActualiserActionPerformed

    private void btnRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechercheActionPerformed
        int c;
        String tf = jTextFieldRecherche.getText();
        try {
            Connection con = ConnexionMysqlAdmin.getCon();
            insert = con.prepareStatement("SELECT * FROM audit_produit WHERE type LIKE '%" + tf + "%'");
            ResultSet rs = insert.executeQuery();
            ResultSetMetaData Rss = rs.getMetaData();
            c = Rss.getColumnCount();

            DefaultTableModel Df = (DefaultTableModel) jTableProduits.getModel();
            Df.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int a = 1; a < c; a++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("designation"));
                    v2.add(rs.getString("stock_ancien"));     
                    v2.add(rs.getString("stock_nouv"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("type"));
                    v2.add(rs.getString("utilisateur"));  
                }

                Df.addRow(v2);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur!");
        }
    }//GEN-LAST:event_btnRechercheActionPerformed

    private void jTableProduitsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProduitsMouseClicked


    }//GEN-LAST:event_jTableProduitsMouseClicked

    private void jTextFieldRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRechercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRechercheActionPerformed

    private void jTableProduitsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProduitsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableProduitsMouseEntered

    private void btnProduitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProduitMouseClicked
        AuditProduit sf = new AuditProduit();
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
            java.util.logging.Logger.getLogger(AuditProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuditProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuditProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuditProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuditProduit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiser;
    private javax.swing.JLabel btnProduit;
    private javax.swing.JButton btnRecherche;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduits;
    private javax.swing.JTextField jTextFieldRecherche;
    // End of variables declaration//GEN-END:variables
}
