package persons;

import java.io.Serializable;
import view.tableModel.Arrayable;

public class PhysicalPerson extends Client implements Serializable, Cloneable, Arrayable{

    private int cpf;

    public PhysicalPerson(int cpf, String address, String name, String email, String contact) {
        super(address, name, email, contact);
        this.cpf = cpf;
    }

    @Override
    public String describe() {
        return getName() + sep + getEmail() + sep + this.cpf;
    }

    @Override
    public Object[] attributesToArray(String[] order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object setValue(String variable, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
