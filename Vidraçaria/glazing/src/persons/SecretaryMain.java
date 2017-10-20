/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

/**
 *
 * @author Marcus
 */
public class SecretaryMain {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SecretaryCrud cnj = new SecretaryCrud();
        
       SecretaryFrame crd = new SecretaryFrame(cnj);
        crd.setVisible(true);        
    }
    
}

