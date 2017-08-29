/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glazing;

/**
 *
 * @author andre
 */
public class Store {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Client cli = new Client("A", "B", Client.clientTypes.person, "D");
        
        Controller ctrl = new Controller();
        ctrl.add(cli);
       
        
        ctrl.listClients();
        
        Client cli1 = new Client("c", "B", Client.clientTypes.person, "D");
        System.out.println(ctrl.remove(cli1));
        System.out.println(ctrl.remove(cli));
        
        ctrl.listClients();
        
       
       
        
        
    }
    
}
