/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.des.produit;

import Projet.ConnexionMysql;
import gestion.des.produit.dao.ConnectDB;
import gestion.des.produit.modele.Client;
import gestion.des.produit.modele.Fornisseur;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;

/**
 *
 * @author Lovasoa
 */
public class Forniseur_Client extends javax.swing.JFrame {

    /**
     * Creates new form Forniseur_Client
     */
    public Forniseur_Client() {
        initComponents();
        buttonGroup1.add(forni);
        buttonGroup1.add(client);
        icon();
    }
    ConnectDB db;

    void icon() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        forni = new javax.swing.JRadioButton();
        client = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldTel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldAdr = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnAjouter = new javax.swing.JButton();
        btnRechercher = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClient = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFournisseur = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        btnActualiser = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnClientFournisseur = new javax.swing.JLabel();

        setTitle("Fournisseur / Client");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        forni.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        forni.setSelected(true);
        forni.setText("Fournisseur");
        jPanel2.add(forni, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 77, -1, -1));

        client.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        client.setText("Client");
        jPanel2.add(client, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 119, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel1.setText("Catégorie :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel2.setText("Nom et Prénoms :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        jTextFieldNom.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel2.add(jTextFieldNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 60, 220, 32));

        jTextFieldTel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel2.add(jTextFieldTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 100, 220, 32));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel3.setText("N° téléphone:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setText("Adresse:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 94, -1));

        jTextFieldAdr.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel2.add(jTextFieldAdr, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 140, 220, 32));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel5.setText("Ville :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Antananarivo", "Fianarantsoa", "Mahajanga", "Toliara", "Antsiranana", "Toamasina" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(828, 22, -1, 36));

        btnAjouter.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        btnAjouter.setForeground(new java.awt.Color(0, 153, 153));
        btnAjouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/ajouter.png"))); // NOI18N
        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });
        jPanel2.add(btnAjouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 202, 137, 45));

        btnRechercher.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        btnRechercher.setForeground(new java.awt.Color(0, 153, 153));
        btnRechercher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/viewmag--icone-5948-32.png"))); // NOI18N
        btnRechercher.setText("rechercher");
        btnRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercherActionPerformed(evt);
            }
        });
        jPanel2.add(btnRechercher, new org.netbeans.lib.awtextra.AbsoluteConstraints(819, 202, 167, 40));

        btnModifier.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        btnModifier.setForeground(new java.awt.Color(0, 153, 153));
        btnModifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/User-Files-icon.png"))); // NOI18N
        btnModifier.setText("Modifier");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });
        jPanel2.add(btnModifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 202, -1, 45));

        btnSupprimer.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        btnSupprimer.setForeground(new java.awt.Color(0, 153, 153));
        btnSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/supprimer.png"))); // NOI18N
        btnSupprimer.setText("Supprimer");
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });
        jPanel2.add(btnSupprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 202, -1, 45));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel6.setText("Id: ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jTextFieldId.setEditable(false);
        jTextFieldId.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextFieldId.setForeground(new java.awt.Color(255, 0, 0));
        jTextFieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 10, 220, 32));

        jTableClient.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°client", "nom prenom", "N°telephone", "Adresse"
            }
        ));
        jTableClient.setSelectionBackground(new java.awt.Color(0, 102, 255));
        jTableClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClient);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 324, 421, 188));

        jTableFournisseur.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableFournisseur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N°forn", "Nom Prenom", "N°telephone", "Adresse", "Ville"
            }
        ));
        jTableFournisseur.setSelectionBackground(new java.awt.Color(0, 102, 255));
        jTableFournisseur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFournisseurMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableFournisseur);
        if (jTableFournisseur.getColumnModel().getColumnCount() > 0) {
            jTableFournisseur.getColumnModel().getColumn(2).setResizable(false);
            jTableFournisseur.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 324, 541, 188));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setText("Clients");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 279, 80, 33));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setText("Fournisseur");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 279, 146, 33));

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(204, 0, 51));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nom_prenom", "Ville " }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 205, -1, 39));

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 206, 149, 36));

        btnActualiser.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        btnActualiser.setForeground(new java.awt.Color(0, 153, 153));
        btnActualiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/modifier.png"))); // NOI18N
        btnActualiser.setText("actualiser");
        btnActualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualiserActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualiser, new org.netbeans.lib.awtextra.AbsoluteConstraints(819, 248, 167, 40));

        jLabel9.setFont(new java.awt.Font("PMingLiU", 1, 30)); // NOI18N
        jLabel9.setText("Client et Fournisseur");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 290, 60));

        btnClientFournisseur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/forum-des-personnes-utilisateurs-icone-3717-128.png"))); // NOI18N
        btnClientFournisseur.setToolTipText("tout concerné avec les fornisseurs et les clients");
        btnClientFournisseur.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClientFournisseur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClientFournisseurMouseClicked(evt);
            }
        });
        jPanel2.add(btnClientFournisseur, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 120, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    PreparedStatement insert;
    PreparedStatement search;
    private void jTableFournisseurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFournisseurMouseClicked
        int i;
        try {
            i = jTableFournisseur.getSelectedRow();

            jTextFieldId.setText(jTableFournisseur.getValueAt(i, 0) + "");
            jTextFieldNom.setText(jTableFournisseur.getValueAt(i, 1) + "");
            jTextFieldTel.setText(jTableFournisseur.getValueAt(i, 2) + "");
            jTextFieldAdr.setText(jTableFournisseur.getValueAt(i, 3) + "");
            forni.setSelected(true);
        } catch (Exception e) {

        }

    }//GEN-LAST:event_jTableFournisseurMouseClicked

    private void jTableClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientMouseClicked
        int i;
        try {
            i = jTableClient.getSelectedRow();
            System.out.println("i=" + i);
            jTextFieldId.setText(jTableClient.getValueAt(i, 0) + "");
            jTextFieldNom.setText(jTableClient.getValueAt(i, 1) + "");
            jTextFieldTel.setText(jTableClient.getValueAt(i, 2) + "");
            jTextFieldAdr.setText(jTableClient.getValueAt(i, 3) + "");
            client.setSelected(true);

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTableClientMouseClicked

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        String nom = jTextFieldNom.getText();
        String tel = jTextFieldTel.getText();
        String adr = jTextFieldAdr.getText();
        try {
            if (nom.equals("") || tel.equals("") || adr.equals("")) {
                JOptionPane.showMessageDialog(null, "Remplissez les champs vides!");
            } else {

                if (forni.isSelected()) {
                    Fornisseur fr = new Fornisseur(jTextFieldNom.getText() + "", jTextFieldTel.getText() + "",
                            jTextFieldAdr.getText() + "", jComboBox1.getSelectedItem() + "");

                    Connection con = ConnexionMysql.getCon();
                    search = con.prepareStatement("SELECT * FROM fornisseur WHERE nom_prenom = '" + nom + "'");
                    ResultSet rs = search.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Fournisseur déjà existe dans la liste!");
                    } else {

                        db.insertFornisseur(fr);
                        jTextFieldId.setText("");
                        jTextFieldNom.setText("");
                        jTextFieldTel.setText("");
                        jTextFieldAdr.setText("");
                        jTextFieldNom.requestFocus();
                    }

                } else if (client.isSelected()) {
                    Client cl = new Client(jTextFieldNom.getText() + "", jTextFieldTel.getText() + "",
                            jTextFieldAdr.getText());

                    Connection con = ConnexionMysql.getCon();
                    search = con.prepareStatement("SELECT * FROM client WHERE nom_prenom = '" + nom + "'");
                    ResultSet rs = search.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Client déjà existe dans la liste!");
                    } else {
                        db.insertClient(cl);
                        jTextFieldId.setText("");
                        jTextFieldNom.setText("");
                        jTextFieldTel.setText("");
                        jTextFieldAdr.setText("");
                        jTextFieldNom.requestFocus();
                    }
                }

                db.AllClient(jTableClient);
                db.AllFornisseur(jTableFournisseur);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur operation");
        }
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        //  db.AllFornisseur(jTable2);db.AllClient(jTable1);
    }//GEN-LAST:event_formWindowActivated

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        try {
            if (forni.isSelected()) {
                if (JOptionPane.showConfirmDialog(null, "Confirmer la supression ?", "suppression",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    db.DeleteForn(Integer.parseInt(jTextFieldId.getText()));
                    db.DeleteAllElementTab(jTableFournisseur, 4, 49);
                    db.DeleteAllElementTab(jTableClient, 3, 49);
                }
            } else if (client.isSelected()) {
                if (JOptionPane.showConfirmDialog(null, "Confirmer la suppression ?", "suppression",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    db.DeleteClient(Integer.parseInt(jTextFieldId.getText()));
                    db.DeleteAllElementTab(jTableFournisseur, 4, 49);
                    db.DeleteAllElementTab(jTableClient, 3, 49);
                }
            }

            db.AllClient(jTableClient);
            db.AllFornisseur(jTableFournisseur);
            jTextFieldId.setText("");
            jTextFieldNom.setText("");
            jTextFieldTel.setText("");
            jTextFieldAdr.setText("");
            jTextFieldNom.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ereur operation");
        }
    }//GEN-LAST:event_btnSupprimerActionPerformed

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        String nom = jTextFieldNom.getText();
        String tel = jTextFieldTel.getText();
        String adr = jTextFieldAdr.getText();
        try {
            if (nom.equals("") || tel.equals("") || adr.equals("")) {
                JOptionPane.showMessageDialog(null, "Remplissez les champs vides!");
            } else {
                if (forni.isSelected()) {
                    Fornisseur fr = new Fornisseur(jTextFieldNom.getText() + "", jTextFieldTel.getText() + "",
                            jTextFieldAdr.getText() + "", jComboBox1.getSelectedItem() + "");

                    db.UpdatForn(Integer.parseInt(jTextFieldId.getText()), fr);
                    jTextFieldNom.setText("");
                    jTextFieldTel.setText("");
                    jTextFieldAdr.setText("");
                    jTextFieldNom.requestFocus();
                } else if (client.isSelected()) {
                    Client cl = new Client(jTextFieldNom.getText() + "", jTextFieldTel.getText() + "",
                            jTextFieldAdr.getText());
                    db.UpdatClient(Integer.parseInt(jTextFieldId.getText()), cl);
                    jTextFieldId.setText("");
                    jTextFieldNom.setText("");
                    jTextFieldTel.setText("");
                    jTextFieldAdr.setText("");
                    jTextFieldNom.requestFocus();
                }

                db.AllClient(jTableClient);
                db.AllFornisseur(jTableFournisseur);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ereur operation");
        }
    }//GEN-LAST:event_btnModifierActionPerformed

    private void btnRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechercherActionPerformed
        if (forni.isSelected()) {
            db.DeleteAllElementTab(jTableFournisseur, 4, 49);
            db.FindFornisseur(jTableFournisseur, jComboBox2.getSelectedItem().toString(), jTextField5.getText());
        } else if (client.isSelected()) {
            db.DeleteAllElementTab(jTableClient, 3, 49);
            db.FindClient(jTableClient, jTextField5.getText());
        }
    }//GEN-LAST:event_btnRechercherActionPerformed

    private void btnActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualiserActionPerformed
        db.AllClient(jTableClient);
        db.AllFornisseur(jTableFournisseur);
        jTextFieldNom.setText("");
        jTextFieldTel.setText("");
        jTextFieldAdr.setText("");
        jTextFieldNom.requestFocus();
    }//GEN-LAST:event_btnActualiserActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        db = new ConnectDB();
        db.ConnexionIntoDataBase();
        db.AllFornisseur(jTableFournisseur);
        db.AllClient(jTableClient);
    }//GEN-LAST:event_formWindowOpened

    private void jTextFieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdActionPerformed

    private void btnClientFournisseurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientFournisseurMouseClicked
        Forniseur_Client fc = new Forniseur_Client();
        fc.setVisible(true);
    }//GEN-LAST:event_btnClientFournisseurMouseClicked

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
            java.util.logging.Logger.getLogger(Forniseur_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Forniseur_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Forniseur_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forniseur_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Forniseur_Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiser;
    private javax.swing.JButton btnAjouter;
    private javax.swing.JLabel btnClientFournisseur;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnRechercher;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton client;
    private javax.swing.JRadioButton forni;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableClient;
    private javax.swing.JTable jTableFournisseur;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextFieldAdr;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldTel;
    // End of variables declaration//GEN-END:variables
}