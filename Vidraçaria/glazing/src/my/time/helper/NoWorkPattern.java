/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.time.helper;

import my.time.helper.NoWorkElem;
import java.util.ArrayList;
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
        //ArrayList newArrayList = (ArrayList) oldArrayList.clone();
        //return (List<NoWorkElem>) patterns.clone();
        return this.patterns;
    }
    
    public boolean removePattern(int index){
        if(index < this.patterns.size()){
            patterns.remove(index);
            return true;
        }
        return false;
    }
}
