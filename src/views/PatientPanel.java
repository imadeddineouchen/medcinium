/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.dao.DAOFactory;
import models.Patient;

/**
 *
 * @author zianwar
 */
public class PatientPanel extends javax.swing.JPanel implements ListSelectionListener{

    /**
     * Creates new form PatientPanel
     */
    public PatientPanel() {
        initComponents();
        ResultSet rs = DAOFactory.getPatientDAO().allToResultSet();
        refreshTable(rs);
        
        ListSelectionModel selectionModel = patientsTable.getSelectionModel();
        selectionModel.addListSelectionListener(this);
    }

    public void refreshTable(ResultSet rs) {
        try {
            patientsTable.setModel(buildTableModel(rs));
        } catch (Exception ex) {
            System.out.println("Error in setting table model.");
        }
    }
    
    public  DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    columnNames.add("N˚ Patient");
    columnNames.add("Nom");
    columnNames.add("Prénom");
    
    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        patientsListPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientsTable = new javax.swing.JTable();
        addPatientButton = new javax.swing.JButton();
        patientInfoPanel = new javax.swing.JPanel();
        patientNumberLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        displayProfileButton = new javax.swing.JButton();
        modifyPatientButton = new javax.swing.JButton();
        deletePatientButton = new javax.swing.JButton();
        lastNameLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        cinLabel = new javax.swing.JLabel();
        birthDateLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        patientsListPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des patients", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        patientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N˚ Patient", "Nom", "Prénom"
            }
        ));
        jScrollPane1.setViewportView(patientsTable);

        javax.swing.GroupLayout patientsListPanelLayout = new javax.swing.GroupLayout(patientsListPanel);
        patientsListPanel.setLayout(patientsListPanelLayout);
        patientsListPanelLayout.setHorizontalGroup(
            patientsListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patientsListPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        patientsListPanelLayout.setVerticalGroup(
            patientsListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientsListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        addPatientButton.setText("Ajouter un patient");
        addPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPatientButtonActionPerformed(evt);
            }
        });

        patientInfoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        patientNumberLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        patientNumberLabel.setText("Patient N˚");

        jLabel2.setText("Nom");

        jLabel3.setText("Age");

        jLabel4.setText("Prénom");

        jLabel5.setText("Date de naissance");

        jLabel6.setText("Sexe");

        jLabel7.setText("CIN");

        jLabel8.setText("Adresse");

        jLabel9.setText("Ville");

        displayProfileButton.setText("Afficher le profil");
        displayProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayProfileButtonActionPerformed(evt);
            }
        });

        modifyPatientButton.setText("Modifier");
        modifyPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyPatientButtonActionPerformed(evt);
            }
        });

        deletePatientButton.setText("Supprimer");
        deletePatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePatientButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patientInfoPanelLayout = new javax.swing.GroupLayout(patientInfoPanel);
        patientInfoPanel.setLayout(patientInfoPanelLayout);
        patientInfoPanelLayout.setHorizontalGroup(
            patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientInfoPanelLayout.createSequentialGroup()
                .addGroup(patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patientInfoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(displayProfileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modifyPatientButton))
                    .addGroup(patientInfoPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deletePatientButton)
                    .addComponent(lastNameLabel)
                    .addComponent(nameLabel)
                    .addComponent(ageLabel)
                    .addComponent(genderLabel)
                    .addComponent(cityLabel)
                    .addComponent(cinLabel)
                    .addComponent(birthDateLabel)
                    .addComponent(addressLabel))
                .addContainerGap())
            .addGroup(patientInfoPanelLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(patientNumberLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        patientInfoPanelLayout.setVerticalGroup(
            patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patientNumberLabel)
                .addGap(43, 43, 43)
                .addGroup(patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lastNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ageLabel))
                .addGap(18, 18, 18)
                .addGroup(patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(genderLabel))
                .addGap(18, 18, 18)
                .addGroup(patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(birthDateLabel))
                .addGap(18, 18, 18)
                .addGroup(patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cinLabel))
                .addGap(18, 18, 18)
                .addGroup(patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(addressLabel))
                .addGap(18, 18, 18)
                .addGroup(patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayProfileButton)
                    .addComponent(modifyPatientButton)
                    .addComponent(deletePatientButton))
                .addContainerGap())
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(addPatientButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(patientsListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(patientInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(patientsListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addPatientButton)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void displayProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayProfileButtonActionPerformed
        String num = null;
            TableModel model = (TableModel)patientsTable.getModel();
            num = String.valueOf(model.getValueAt(patientsTable.getSelectedRow(), 0));
         if(num != null) {
            try { 
                
                Patient currentPatient = DAOFactory.getPatientDAO().find(num);
                new PatientFrame(currentPatient).setVisible(true);
        
        } catch (Exception e) {
            System.out.println("Erreur lors de l'affichage");
        }
         }
    }//GEN-LAST:event_displayProfileButtonActionPerformed

    private void deletePatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePatientButtonActionPerformed
        String num = null;
        try {
            TableModel model = (TableModel)patientsTable.getModel();
            num = String.valueOf(model.getValueAt(patientsTable.getSelectedRow(), 0));
         } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner un patient", "Erreur", JOptionPane.ERROR_MESSAGE);        
        }
        if(num != null) {
            int val = JOptionPane.showConfirmDialog(this, "Etes vous sur?", "Validation", JOptionPane.OK_CANCEL_OPTION);
            if(val == 0) {
                Patient currentPatient = DAOFactory.getPatientDAO().find(num);
                DAOFactory.getPatientDAO().delete(currentPatient);
                        
                SwingUtilities.updateComponentTreeUI(this);
                this.invalidate();
                this.validate();
                this.repaint();
             
                ResultSet rs = DAOFactory.getPatientDAO().allToResultSet();

                refreshTable(rs);
            }
        }
    }//GEN-LAST:event_deletePatientButtonActionPerformed

    private void modifyPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyPatientButtonActionPerformed
        String num = null;
        try {
            TableModel model = (TableModel)patientsTable.getModel();
            num = String.valueOf(model.getValueAt(patientsTable.getSelectedRow(), 0));
         } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner un patient", "Erreur", JOptionPane.ERROR_MESSAGE);        
        }
        
        if(num != null) {
            try {
                Patient currentPatient = DAOFactory.getPatientDAO().find(num);
//                new ModifyPatientFrame(currentPatient).setVisible(true);
            
            } catch (Exception e) {
                System.out.println("Erreur lors de la modification");
            }
        }
    }//GEN-LAST:event_modifyPatientButtonActionPerformed

    private void addPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPatientButtonActionPerformed
        try {
//            new AddPatientFrame().setVisible(true);
            
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout");
        }
    }//GEN-LAST:event_addPatientButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPatientButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JLabel birthDateLabel;
    private javax.swing.JLabel cinLabel;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JButton deletePatientButton;
    private javax.swing.JButton displayProfileButton;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton modifyPatientButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel patientInfoPanel;
    private javax.swing.JLabel patientNumberLabel;
    private javax.swing.JPanel patientsListPanel;
    private javax.swing.JTable patientsTable;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (event.getSource() == patientsTable.getSelectionModel() && event.getValueIsAdjusting()) {
            
            TableModel model = (TableModel)patientsTable.getModel();
            String num = String.valueOf(model.getValueAt(patientsTable.getSelectedRow(), 0));
           
            Patient patientSelected = DAOFactory.getPatientDAO().find(num);
            
            patientNumberLabel.setText("Patient N˚ " + num);
            lastNameLabel.setText(patientSelected.getLastName());
            nameLabel.setText(patientSelected.getName());
            
            String dob = String.valueOf(patientSelected.getBirthDate());
            int yearDOB = Integer.parseInt(dob.substring(0, 4));
            
            int thisYear = Calendar.getInstance().get(Calendar.YEAR);
            
            ageLabel.setText(String.valueOf(thisYear-yearDOB));
            genderLabel.setText(patientSelected.getSexe());
            birthDateLabel.setText(dob);
            cinLabel.setText(patientSelected.getCin());
            addressLabel.setText(patientSelected.getAddress());
            cityLabel.setText(patientSelected.getCity());
        }
    }
}
