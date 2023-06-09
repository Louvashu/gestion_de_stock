/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.des.produit;

import gestion.des.produit.dao.ConnectDB;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author AmineGasa
 */
public class Main_frame_Admin extends javax.swing.JFrame {

    public Main_frame_Admin() {
        initComponents();
        showDate();
        showTime();
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        icon();
        setResizable(false);
    }

    void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().
                getResource("Cartgrill_icon-icons.com_51191.png")));
    }

    void showDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("E dd-MM-YYYY");
        jLabel3.setText(sdf.format(d));

    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                jLabel1.setText(sdf.format(d));
            }
        }).start();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnVentesAdmin = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnProduitAdmin = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnApprovisionnementAdmin = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de stock");
        setBounds(new java.awt.Rectangle(200, 120, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("h");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 241, 43));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 102));
        jLabel3.setText("u");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 49, 181, 42));

        btnVentesAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/ecommerce-panier-shoping-webshop-icone-6530-128.png"))); // NOI18N
        btnVentesAdmin.setToolTipText("tout concerné avec les achates");
        btnVentesAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVentesAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentesAdminMouseClicked(evt);
            }
        });
        jPanel1.add(btnVentesAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 117));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Audit produits");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 180, -1));

        btnProduitAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/warehouse(1).png"))); // NOI18N
        btnProduitAdmin.setToolTipText("tout concerné avec le stock");
        btnProduitAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnProduitAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProduitAdminMouseClicked(evt);
            }
        });
        jPanel1.add(btnProduitAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, 130));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Audit ventes");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        btnApprovisionnementAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/Accounting_icon-icons.com_74682(2).png"))); // NOI18N
        btnApprovisionnementAdmin.setToolTipText("tout concerné avec les ventes");
        btnApprovisionnementAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnApprovisionnementAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnApprovisionnementAdminMouseClicked(evt);
            }
        });
        jPanel1.add(btnApprovisionnementAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 136, 120));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Audit approvisionnement");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/businessapplications_information_briefcase_negoci_2317.png"))); // NOI18N
        jLabel13.setToolTipText("information sur l'application");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 6, -1, 53));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/arie.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVentesAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentesAdminMouseClicked
        AuditVentes audit_ventes = new AuditVentes();
        audit_ventes.setVisible(true);
    }//GEN-LAST:event_btnVentesAdminMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void btnProduitAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProduitAdminMouseClicked
        AuditProduit prod = new AuditProduit();
        prod.setVisible(true);
    }//GEN-LAST:event_btnProduitAdminMouseClicked

    private void btnApprovisionnementAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApprovisionnementAdminMouseClicked
        AuditApprovisionnement app = new AuditApprovisionnement();
        app.setVisible(true);
    }//GEN-LAST:event_btnApprovisionnementAdminMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        AppInfo ap = new AppInfo();
        ap.setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

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
            java.util.logging.Logger.getLogger(Main_frame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_frame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_frame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_frame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_frame_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnApprovisionnementAdmin;
    private javax.swing.JLabel btnProduitAdmin;
    private javax.swing.JLabel btnVentesAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
