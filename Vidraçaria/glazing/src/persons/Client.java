package persons;

import visit.Visit;

public class Client extends Person {

    private String address;
        
        
    public Client(String address, String name, String email, String contact) {
        super(name, email, contact);
        this.address = address;
    }

    public Client(String address, String name) {
        super(name);
        this.address = address;
    }
        
    public Visit requestVisit(){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    
        
        

}
