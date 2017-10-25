/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import visit.Visit;

/**
 *
 * @author andre
 */
public class VisitTableModel extends AbstractTableModel{
    /*
    private Date start;
    private Date finish;
    private int status;
    private String description;
    private String name;
    private Project project;
    private List<Driver> visitor;
    private Client client;
    private Vehicle vehicle;
    */
    
    private final String[] colunas = {"Nome","Início", "Fim", "Status", "Descrição"};
    
    private final List<Visit> visit;
    
    
    @Override
    public int getRowCount() {
        return visit.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public VisitTableModel(List<Visit> vis) {
        this.visit = vis;
    }
    
    
    
}
