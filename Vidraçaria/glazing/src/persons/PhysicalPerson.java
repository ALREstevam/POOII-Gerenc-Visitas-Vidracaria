package persons;

import java.io.Serializable;

public class PhysicalPerson extends Client implements Serializable, Cloneable{

    private int cpf;

    public PhysicalPerson(int cpf, String address, String name, String email, String contact) {
        super(address, name, email, contact);
        this.cpf = cpf;
    }

    @Override
    public String describe() {
        return getName() + sep + getEmail() + sep + this.cpf;
    }

    
}
