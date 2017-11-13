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
 *
 * @author andre
 */
public class ControlHelper<E extends Descriptible>{
    
    void insert(Map m, E elem){
        m.put(elem.describe(), elem);
    }
    
    void delete(Map m, E elem){
        m.remove(elem.describe(), elem);
    }
    
    void delete(Map m, String key){
        m.remove(key);
    }
    
    public Map<String,E> get(Map m) {
        Map<String,E> rsp = Collections.unmodifiableMap(m);
        return rsp;
    }
    
    public boolean update(Map m, String oldDescription, E newElem){
        if(m.containsKey(oldDescription)){
            m.remove(oldDescription);
            m.put(newElem.describe(), newElem);
            return true;
        }
        return false;
    }
    
    public boolean update(Map m, E oldElem, E newElem){
        return this.update(m, oldElem.describe(), newElem);
    }
}
