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
    //ATTRIBUTES
    public enum clientTypes{
        legalPerson, physicalPerson,
    }
    
    private String name;
    private String contact;
    private clientTypes type;
    private String address;
    
    //CONSTRUCTOR
    public Client(String name, String contact, clientTypes type, String address) {
        this.name = name;
        this.contact = contact;
        this.type = type;
        this.address = address;
    }
    
    //GETTERS AND SETTERS
    
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public clientTypes getType() {
        return type;
    }

    public void setType(clientTypes type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
