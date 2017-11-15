package persons;

import java.io.Serializable;
import view.tableModel.Arrayable;

/**
 * This is the PhysicalPerson class, derived from the Client class
 * @author Pedro
 */
public class PhysicalPerson extends Client implements Serializable, Cloneable, Arrayable{

    private int cpf;

    /**
     * This is the constructor of the PhysicalPerson class. This constructor
     * has five parameters
     * @param cpf
     * @param address
     * @param name
     * @param email
     * @param contact
     */
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
        Object[] rsp = new Object[5];
        int rspCount = 0;
        for (String s : order) {
            switch (s) {
                case "nome":
                    rsp[rspCount] = this.getName();
                    break;
                case "email":
                    rsp[rspCount] = this.getEmail();
                    break;
                case "contato":
                    rsp[rspCount] = this.getContact();
                    break;
                case "endereco":
                    rsp[rspCount] = this.getAddress();
                    break;
                case "cpf":
                    rsp[rspCount] = this.getCpf();
                    break;
                default:
                    rsp[rspCount] = "";
                    break;
            }
            rspCount++;
        }
        return rsp;
    }

    @Override
    public Object setValue(String variable, Object value) {
        switch (variable) {
            case "nome":
                this.setName((String) value);
                break;
            case "email":
                this.setEmail((String) value);
                break;
            case "contato":
                this.setContact((String) value);
                break;
            case "endereco":
                this.setAddress((String) value);
                break;
            case "cpf":
                this.setCpf((int) value);
                break;
            default:
                break;
        }
        return this;
    }

    /**
     * This method get the PhysicalPerson's cpf 
     * @return int
     */
    public int getCpf() {
        return cpf;
    }

    /**
     * This method set the PhysicalPerson's cpf
     * @param cpf
     */
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
}
