/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.comboboxModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author andre
 */
public class PersonalComboboxModel<E extends Descriptible> extends AbstractListModel implements ComboBoxModel {
    private List<E> elemList;
    private String separator;
    private E selected = null; /*(elemList != null && elemList.size() > 0)?elemList.get(0):null;*/
    
    @Override
    public int getSize() {
        if(this.elemList == null){
            return 0;
        }else{
            return this.elemList.size();
        }
    }

    @Override
    public E getElementAt(int index) {
        return this.elemList.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        System.out.println("SELECTED!");
        this.selected = (E)anItem;
        fireContentsChanged(this.elemList, 0, this.elemList.size());
    }

    @Override
    public Object getSelectedItem() {
        return this.selected;
    }
    
    public boolean add(E element){
        this.elemList.add(element);
        fireContentsChanged(this.elemList, 0, this.elemList.size());
        return true;
    }
    
   
    /**
     * Generates a DefaultComboboxModel using the describe() operation to do so
     * @param elemList
     * @param separator a String that should be between two arguments
     * @return 
     */
    public void add(List<E> elemList){
        this.elemList = elemList;
    }
    
    public boolean remove(E element){
        this.elemList.remove(element);
        fireContentsChanged(this.elemList, 0, this.elemList.size());
        return true;
    }
    
    public void clear(E element){
        this.elemList.clear();
        fireContentsChanged(this.elemList, 0, this.elemList.size());
    }
}
