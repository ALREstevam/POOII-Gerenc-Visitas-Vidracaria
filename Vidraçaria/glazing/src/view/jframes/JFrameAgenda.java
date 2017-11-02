/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.jframes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import persons.Driver;
import persons.Employee;
import view.comboboxModel.GeneralComboboxModel;
import view.comboboxModel.PersonalComboboxModel;
import visit.Project;
import visit.Vehicle;

/**
 *
 * @author andre
 */
public class JFrameAgenda extends javax.swing.JFrame {
    //Selected values
    private Vehicle selectedVehicle;
    private Project selectedProject;
    private Map<String, Driver> selectedDrivers;
    
    //GeneralComboboxModel
    private GeneralComboboxModel<Vehicle> gcModelVehicle;
    private GeneralComboboxModel<Project> gcModelProject;
    private GeneralComboboxModel<Driver> gcModelDriver;
    
    //List/Map
    private List<Vehicle> lstVehicles;
    private Map<String, Vehicle> mpVehicles;
    private List<Project> lstProjects;
    private Map<String, Project> mpProjects;
    private List<Driver> lstDrivers;
    private Map<String, Driver> mpDrivers;
    
    
    /**
     * 
     * @param drv
     * @param veh
     * @param proj 
     */
    public JFrameAgenda(Map<String, Driver> drv, Map<String,Vehicle> veh, Map<String,Project> proj) {
        //Initialize selected
        this.selectedDrivers = new TreeMap<>();

        //Fill local maps
        this.mpVehicles = veh;
        this.mpProjects = proj;
        this.mpDrivers = drv;
        
        //Fill local lists
        this.lstVehicles = new ArrayList<>(veh.values());
        this.lstProjects = new ArrayList<>(proj.values());
        this.lstDrivers = new ArrayList<>(drv.values());
        
        //Generate GeneralComboboxmODEL
        this.gcModelVehicle = new GeneralComboboxModel<>();
        this.gcModelProject = new GeneralComboboxModel<>();
        this.gcModelDriver = new GeneralComboboxModel<>();
        
        
        //Instatiate general 
        DefaultComboBoxModel dcModelVehicle = gcModelVehicle.getComboBoxModelUsingDescription(lstVehicles);
        DefaultComboBoxModel dcModelProject = gcModelProject.getComboBoxModelUsingDescription(lstProjects);
        DefaultComboBoxModel dcModelDriver = gcModelDriver.getComboBoxModelUsingDescription(lstDrivers);
        
        initComponents();
        
        this.jListVehicles.setModel(dcModelVehicle);
        this.jListProject.setModel(dcModelProject);
        this.jListDrivers.setModel(dcModelDriver);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPabel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButtonAddProject = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jListProject = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListDrivers = new javax.swing.JList<>();
        jButtonAddDriver = new javax.swing.JButton();
        jButtonAddVehicle = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListVehicles = new javax.swing.JList<>();
        jPanelDateChoose = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSpinnerHours = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jFormattedTextDate = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextFieldTime = new javax.swing.JFormattedTextField();
        jButtonConfirmTime = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelProject = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListSelectedDrivers = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSelectedVehicles = new javax.swing.JList<>();
        jButtonClean = new javax.swing.JButton();
        jButtonValidate = new javax.swing.JButton();
        jLabelDuration = new javax.swing.JLabel();
        jLabeDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Selecionar");

        jButtonAddProject.setText(">");
        jButtonAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProjectActionPerformed(evt);
            }
        });

        jListProject.setBorder(javax.swing.BorderFactory.createTitledBorder("Projeto"));
        jListProject.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane8.setViewportView(jListProject);

        jListDrivers.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionários"));
        jListDrivers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(jListDrivers);

        jButtonAddDriver.setText(">");
        jButtonAddDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddDriverActionPerformed(evt);
            }
        });

        jButtonAddVehicle.setText(">");
        jButtonAddVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddVehicleActionPerformed(evt);
            }
        });

        jListVehicles.setBorder(javax.swing.BorderFactory.createTitledBorder("Veículo"));
        jListVehicles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(jListVehicles);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButtonAddProject)
                .addGap(154, 154, 154)
                .addComponent(jButtonAddDriver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddVehicle)
                .addGap(85, 85, 85))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddDriver)
                    .addComponent(jButtonAddProject)
                    .addComponent(jButtonAddVehicle))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jLabel8.setText("Duração de");

        jSpinnerHours.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerHoursStateChanged(evt);
            }
        });
        jSpinnerHours.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jSpinnerHoursKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSpinnerHoursKeyTyped(evt);
            }
        });

        jLabel9.setText("horas");

        jLabel10.setText("Data");

        jFormattedTextDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jFormattedTextDate.setText("01/01/2001");
        jFormattedTextDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextDateActionPerformed(evt);
            }
        });

        jLabel12.setText("Horário");

        jFormattedTextFieldTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jFormattedTextFieldTime.setText("13:50");
        jFormattedTextFieldTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldTimeActionPerformed(evt);
            }
        });

        jButtonConfirmTime.setText("Confirmar");
        jButtonConfirmTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmTimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDateChooseLayout = new javax.swing.GroupLayout(jPanelDateChoose);
        jPanelDateChoose.setLayout(jPanelDateChooseLayout);
        jPanelDateChooseLayout.setHorizontalGroup(
            jPanelDateChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDateChooseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDateChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDateChooseLayout.createSequentialGroup()
                        .addGroup(jPanelDateChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDateChooseLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinnerHours, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))
                            .addGroup(jPanelDateChooseLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addGroup(jPanelDateChooseLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextDate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonConfirmTime)))
                .addContainerGap())
        );
        jPanelDateChooseLayout.setVerticalGroup(
            jPanelDateChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDateChooseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDateChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jSpinnerHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDateChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jFormattedTextDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConfirmTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDateChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jFormattedTextFieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPabel1Layout = new javax.swing.GroupLayout(jPabel1);
        jPabel1.setLayout(jPabel1Layout);
        jPabel1Layout.setHorizontalGroup(
            jPabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPabel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanelDateChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPabel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1))
            .addGroup(jPabel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPabel1Layout.setVerticalGroup(
            jPabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPabel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDateChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Criar visita");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Status");

        jButton6.setText("Alocar");

        jLabel11.setText("A tarefa pode ser alocada para: ");

        jLabel13.setText("Status:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addGap(0, 665, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addGap(5, 5, 5)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Selecionado");

        jLabelProject.setText("Projeto: ");

        jListSelectedDrivers.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionários"));
        jScrollPane4.setViewportView(jListSelectedDrivers);

        jListSelectedVehicles.setBorder(javax.swing.BorderFactory.createTitledBorder("Veículo"));
        jScrollPane1.setViewportView(jListSelectedVehicles);

        jButtonClean.setText("Limpar");
        jButtonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanActionPerformed(evt);
            }
        });

        jButtonValidate.setText("Validar");
        jButtonValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValidateActionPerformed(evt);
            }
        });

        jLabelDuration.setText("Duração:");

        jLabeDate.setText("Data:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabelProject)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonClean)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonValidate))
                            .addComponent(jLabelDuration)
                            .addComponent(jLabeDate))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabelProject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDuration)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabeDate)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClean)
                    .addComponent(jButtonValidate))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldTimeActionPerformed

    private void jFormattedTextDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextDateActionPerformed

    private void jButtonAddVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddVehicleActionPerformed
        int index = this.jListVehicles.getSelectedIndex();
        String value = this.jListVehicles.getSelectedValue();
        System.out.println(value);
        System.out.println(index);
        
        if(value == null){
            return;
        }
        
        Vehicle veh = this.mpVehicles.get(value);
        
        System.out.println(veh);
        
        List<Vehicle> lst = new ArrayList<>();
        lst.add(veh);
        
        DefaultComboBoxModel dcModelSelectedVehicle = gcModelVehicle.getComboBoxModelUsingDescription(lst);
        this.jListSelectedVehicles.setModel(dcModelSelectedVehicle);
    }//GEN-LAST:event_jButtonAddVehicleActionPerformed

    private void jButtonAddDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddDriverActionPerformed
        if(this.jListDrivers.getSelectedValue() == null){
            return;
        }
        Driver selectedDrv = this.mpDrivers.get(this.jListDrivers.getSelectedValue());
        System.out.println(selectedDrv);
        this.selectedDrivers.put(selectedDrv.describe(), selectedDrv);     
        this.jListSelectedDrivers.setModel(this.gcModelDriver.getComboBoxModelUsingDescription(new ArrayList<>(selectedDrivers.values())));
        this.lstDrivers.remove(selectedDrv);
        this.jListDrivers.setModel(new GeneralComboboxModel<Driver>().getComboBoxModelUsingDescription(lstDrivers));
    }//GEN-LAST:event_jButtonAddDriverActionPerformed

    private void jButtonAddProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddProjectActionPerformed
       if(this.jListProject.getSelectedValue() == null){
            return;
        }
        this.selectedProject = this.mpProjects.get(this.jListProject.getSelectedValue());
        this.jLabelProject.setText("Projeto: " + selectedProject.describe());
    }//GEN-LAST:event_jButtonAddProjectActionPerformed

    private void jSpinnerHoursStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerHoursStateChanged
        setHoursToJLabel(getHoursFromjSpinner());
    }//GEN-LAST:event_jSpinnerHoursStateChanged

    private void jSpinnerHoursKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinnerHoursKeyTyped
        setHoursToJLabel(getHoursFromjSpinner());
    }//GEN-LAST:event_jSpinnerHoursKeyTyped

    private void jSpinnerHoursKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinnerHoursKeyPressed
        setHoursToJLabel(getHoursFromjSpinner());
    }//GEN-LAST:event_jSpinnerHoursKeyPressed

    private void jButtonConfirmTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmTimeActionPerformed
        String date = jFormattedTextDate.getText();
        String time = jFormattedTextFieldTime.getText();
        
        String concatTime = date + " " + time;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        try{
            LocalDateTime dateTime = LocalDateTime.parse(concatTime, formatter);
            
            this.jLabeDate.setText("Data: " + concatTime);
            
        }catch(RuntimeException e){
            JOptionPane.showMessageDialog(this.jPanelDateChoose,"Algo errado com a data ou horário escolhidos.","Dados inconsistentes", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonConfirmTimeActionPerformed

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
        DefaultComboBoxModel emptyVehicle = gcModelVehicle.getComboBoxModelUsingDescription(new ArrayList<>());
        DefaultComboBoxModel emptyDriver = gcModelDriver.getComboBoxModelUsingDescription(new ArrayList<>());
        this.jListSelectedVehicles.setModel(emptyVehicle);
        this.jListSelectedDrivers.setModel(emptyDriver);
        this.jLabeDate.setText("Data:");
        this.jLabelDuration.setText("Duração:");
        this.jLabelProject.setText("Projeto:");
        this.lstDrivers.addAll(this.selectedDrivers.values());
        this.jListDrivers.setModel(gcModelDriver.getComboBoxModelUsingDescription(this.lstDrivers));
        
    }//GEN-LAST:event_jButtonCleanActionPerformed

    private void jButtonValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValidateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonValidateActionPerformed

    private Integer getHoursFromjSpinner(){
        Integer value = (Integer) this.jSpinnerHours.getValue();
        return value <= 0 ? 0 : value;
    }
    
    private void setHoursToJLabel(int hours){
        String compl = (hours == 1) ? "":"(s)";
        this.jLabelDuration.setText("Duração: " + hours + " hora"+compl);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonAddDriver;
    private javax.swing.JButton jButtonAddProject;
    private javax.swing.JButton jButtonAddVehicle;
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonConfirmTime;
    private javax.swing.JButton jButtonValidate;
    private javax.swing.JFormattedTextField jFormattedTextDate;
    private javax.swing.JFormattedTextField jFormattedTextFieldTime;
    private javax.swing.JLabel jLabeDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDuration;
    private javax.swing.JLabel jLabelProject;
    private javax.swing.JList<String> jListDrivers;
    private javax.swing.JList<String> jListProject;
    private javax.swing.JList<String> jListSelectedDrivers;
    private javax.swing.JList<String> jListSelectedVehicles;
    private javax.swing.JList<String> jListVehicles;
    private javax.swing.JPanel jPabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelDateChoose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSpinner jSpinnerHours;
    // End of variables declaration//GEN-END:variables

    private class testTimeAllocation extends SwingWorker<Void, Void>{
            
        private List<Driver> selectedDrivers;
        private Vehicle selectedVehicle;
        private LocalDateTime date;
        private int duration;
        
        
        @Override
        protected Void doInBackground() throws Exception {
            
        }
        
        @Override
        public void done(){
            
        }
    }




}
