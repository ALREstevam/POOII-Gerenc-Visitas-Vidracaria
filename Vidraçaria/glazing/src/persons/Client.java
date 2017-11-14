package persons;

import java.io.Serializable;
import view.comboboxModel.Descriptible;
import visit.Visit;

public abstract class Client extends Person implements Serializable, Descriptible{

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

    @Override
    public String describe() {
        return getName() + sep + getEmail();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
