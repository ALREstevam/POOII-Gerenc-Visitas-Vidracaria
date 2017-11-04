/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.time.helper;

import my.time.helper.NoWorkElem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author andre
 */
public class NoWorkPattern {
    private List<NoWorkElem> patterns;

    public NoWorkPattern() {
        patterns = new ArrayList<>();
    }
    
    public boolean appendCondition(NoWorkElem elem){
        return this.patterns.add(elem);
    }
    
    public List<NoWorkElem> getPatterns(){
        return Collections.unmodifiableList(this.patterns);
    }
    
    public boolean removePattern(int index){
        if(index < this.patterns.size()){
            patterns.remove(index);
            return true;
        }
        return false;
    }
    
    static public NoWorkPattern getDefault(int minPerBlock){
        NoWorkPattern defnwp = new NoWorkPattern();
        /*
        defnwp.appendCondition(new NoWorkElem(0, 2, 0, 1, 0, 0, 0, 12, 0, 10));
        defnwp.appendCondition(new NoWorkElem(0, 12, 0, 0, 6, 0, 0, 0, 0, 10));
        */
        defnwp.appendCondition(new NoWorkElem(10, 10, 10));
        return defnwp;
    }
    
}
