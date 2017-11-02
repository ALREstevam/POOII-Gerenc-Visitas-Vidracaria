/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tableModel;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * This class creates a GeneralTableModel for any object that implements the 
 * Arrayable interface
 * @author andre
 * @param <E> 
 */
public class GeneralTableModel<E extends Arrayable> extends AbstractTableModel{
    private final String[] columns;
    private final List<E> list;

    /**
     * Contructor
     * @param columns a array of Strings specifing the header of the table
     * @param list a list of objects where each one represents a line of the table
     */
    public GeneralTableModel(String[] columns, List<E> list) {
        this.columns = columns;
        this.list = list;
    }
    
    @Override
    /**
     * Gets the amount of rows in the table
     */
    public int getRowCount() {
        return list.size();
    }

    @Override
    /**
     * Gets the amount of columns in the table
     */
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    /**
     * Gets a value in a specified position of the table
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        E elem = this.list.get(rowIndex);
        return elem.attributesToArray(this.columns)[columnIndex];
    }

   
}
