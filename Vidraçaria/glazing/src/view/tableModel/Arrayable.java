/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tableModel;

/**
 * Defines a object where the attributes can be accessed as a array of Objects
 * @author andre
 */
public interface Arrayable {
    /**
     * Gets all arguments of a object as a Object array, the order of the arguments
     * into the array is specified by the array of Strings 'order'
     * @param order the order of the arguments into the Object array
     * @return 
     */
    public Object[] attributesToArray(String[] order);
}
