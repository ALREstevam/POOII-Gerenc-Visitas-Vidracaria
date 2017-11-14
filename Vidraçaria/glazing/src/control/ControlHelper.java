/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Collections;
import java.util.Map;
import persons.Employee;
import view.comboboxModel.Descriptible;

/**
 * @author andre
 *The ControllerHelp class is derived from Descriptble. Its methods 
 * are associated with the use of the Map Collection
 */
public class ControlHelper<E extends Descriptible>{
   
    /**
    * This method inserts an element into Map
     */ 
    void insert(Map m, E elem){
        m.put(elem.describe(), elem);
    }
    /**
    * This method deletes an element into Map
     */ 
    
    void delete(Map m, E elem){
        m.remove(elem.describe(), elem);
    }
    /**
    * This method deletes a Map key
     */ 
    
    void delete(Map m, String key){
        m.remove(key);
    }

    /**
    * This method get an object from Map 
    * @param m
    * @return Map<String,E>
    */ 
    public Map<String,E> get(Map m) {
        Map<String,E> rsp = Collections.unmodifiableMap(m);
        return rsp;
    }
    /**
    * This method updates a description Map 
    * @param m
    * @param oldDescription
    * @param newElem
    * @return boolean
    */     
    public boolean update(Map m, String oldDescription, E newElem){
        if(m.containsKey(oldDescription)){
            m.remove(oldDescription);
            m.put(newElem.describe(), newElem);
            return true;
        }
        return false;
    }
    
    /**
    * This method updates a element from Map 
    * @param m
    * @param oldElem
    * @param newElem
    * @return boolean
    */     
    
    public boolean update(Map m, E oldElem, E newElem){
        return this.update(m, oldElem.describe(), newElem);
    }
}
