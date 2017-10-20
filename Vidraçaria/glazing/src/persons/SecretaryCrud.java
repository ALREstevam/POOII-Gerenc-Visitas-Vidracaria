/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Pedro
 */
public class SecretaryCrud {
    private List<Secretary> lst;
    
    public SecretaryCrud(){
        this.lst=new ArrayList<>();
}
    public List <Secretary>getLst(){
        
        return lst;
    }
    
     public void setLst(List<Secretary> lst) {
        this.lst = lst;
    }
    
    public boolean add(Secretary sec){
        return this.lst.add(sec);
    }
    
    public boolean remove(Secretary sec){
        return this.lst.remove(sec);
    }
    
    public void edit(Secretary sec, int id){
        this.lst.set(id, sec);
    }

   /* void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

}
   
 





