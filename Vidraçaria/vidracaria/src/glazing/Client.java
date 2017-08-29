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
public class Client {
    public enum clientTypes{
        legalperson,
        person,
    }
    
    private String name;
    private String contact;
    private clientTypes type;
    private String address;
    
   
}
