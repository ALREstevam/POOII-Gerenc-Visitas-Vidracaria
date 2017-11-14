/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.jpanels;

import agenda.neow.agenda.Agenda;
import agenda.neow.nowork.NoWorkPattern;
import control.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import persons.PhysicalPerson;
import persons.Secretary;
import view.tableModel.GeneralTableModel;


/**
 *
 * @author Marcus
 */
public class JPanelPhysicalPerson extends javax.swing.JPanel {
    private Map<String, PhysicalPerson> ppersonMp;
    private List<PhysicalPerson> ppersonLst;
    private GeneralTableModel<PhysicalPerson> ppersonTb;
    private Controller ctrl;
    private List<String> descriptions;
    /**
     * Creates new form JPanelPhysicalPerson
     */
    public JPanelPhysicalPerson() {
        initComponents();
    }

    public JPanelPhysicalPerson(Controller ctrl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanelConsultEdit = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePPerson = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanelAdd = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        FormattedTextCpf = new javax.swing.JFormattedTextField();
        TextName = new javax.swing.JTextField();
        FormattedTextContact = new javax.swing.JFormattedTextField();
        TextEmail = new javax.swing.JTextField();
        TextEndereco = new javax.swing.JTextField();
        BtnAdd = new javax.swing.JButton();
        jPanelRemove = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPPerson = new javax.swing.JList<String>();
        btnDelete = new javax.swing.JButton();

        jLabel2.setText("Consultar e alterar");

        jTablePPerson.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Contato", "Email", "Endereço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTablePPerson);

        javax.swing.GroupLayout jPanelConsultEditLayout = new javax.swing.GroupLayout(jPanelConsultEdit);
        jPanelConsultEdit.setLayout(jPanelConsultEditLayout);
        jPanelConsultEditLayout.setHorizontalGroup(
            jPanelConsultEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConsultEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConsultEditLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelConsultEditLayout.setVerticalGroup(
            jPanelConsultEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("Pessoa Física");

        jLabel3.setText("Inserir");

        FormattedTextCpf.setBorder(javax.swing.BorderFactory.createTitledBorder("CPF"));
        try {
            FormattedTextCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        TextName.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        FormattedTextContact.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));
        try {
            FormattedTextContact.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        TextEmail.setBorder(javax.swing.BorderFactory.createTitledBorder("E-mail"));

        TextEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));
        TextEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextEnderecoActionPerformed(evt);
            }
        });

        BtnAdd.setText("Cadastrar");
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAddLayout = new javax.swing.GroupLayout(jPanelAdd);
        jPanelAdd.setLayout(jPanelAddLayout);
        jPanelAddLayout.setHorizontalGroup(
            jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextName)
                    .addGroup(jPanelAddLayout.createSequentialGroup()
                        .addComponent(FormattedTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FormattedTextContact))
                    .addGroup(jPanelAddLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(TextEmail)
                    .addComponent(TextEndereco)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnAdd)))
                .addContainerGap())
        );
        jPanelAddLayout.setVerticalGroup(
            jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FormattedTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FormattedTextContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Selecionado");

        jListPPerson.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListPPerson);

        btnDelete.setText("Deletar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRemoveLayout = new javax.swing.GroupLayout(jPanelRemove);
        jPanelRemove.setLayout(jPanelRemoveLayout);
        jPanelRemoveLayout.setHorizontalGroup(
            jPanelRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRemoveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanelRemoveLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRemoveLayout.setVerticalGroup(
            jPanelRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRemoveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanelRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelConsultEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelConsultEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        String description = this.jListPPerson.getSelectedValue();

        if(description == null){
            return;
        }

        
        PhysicalPerson ppersonToDelete = this.ppersonMp.get(description);

        if(ppersonToDelete == null){
            return;
        }

        this.ctrl.remove(ppersonToDelete);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void TextEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextEnderecoActionPerformed

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        // TODO add your handling code here:
        try{
            String cpf = this.FormattedTextCpf.getText();
            String contact = this.FormattedTextContact.getText();
            String name = this.TextName.getText();
            String email = this.TextEmail.getText();
            String address = this.TextEndereco.getText();

            int pCpf = 0;
            try {
            pCpf = Integer.parseInt(cpf); 
                    
            } catch (NumberFormatException e) {
                System.out.println("Numero com formato errado!");
            }         

            if(name == null || email == null || contact == null || cpf == null || address == null){
                throw new Exception();
            }

            NoWorkPattern nwp = new NoWorkPattern();
            Agenda agd = new Agenda(nwp);
            PhysicalPerson pperson = new PhysicalPerson(pCpf, name, email, contact, address);
            ctrl.append(pperson);
            this.updateTable();
        }catch(Exception e){
            //JOptionPane.showMessageDialog(this,"Algo errado com os dados inseridos.","Dados inconsistentes", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_BtnAddActionPerformed

    private void updateTable(){
        String[] columns = new String[5];
        
        columns[0] = "nome";
        columns[1] = "cpf";
        columns[2] = "contato";
        columns[3] = "email";
        columns[4] = "endereco";
        
        this.ppersonLst = new ArrayList<>(this.ppersonMp.values());
        this.ppersonTb =  new GeneralTableModel<PhysicalPerson>(columns, ppersonLst, ctrl);
        this.jTablePPerson.setModel(ppersonTb);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JFormattedTextField FormattedTextContact;
    private javax.swing.JFormattedTextField FormattedTextCpf;
    private javax.swing.JTextField TextEmail;
    private javax.swing.JTextField TextEndereco;
    private javax.swing.JTextField TextName;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jListPPerson;
    private javax.swing.JPanel jPanelAdd;
    private javax.swing.JPanel jPanelRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePPerson;
    // End of variables declaration//GEN-END:variables
}
