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
        Object[] rsp = new Object[5];
        int rspCount = 0;
        for (String s : order) {
            switch (s) {
                case "nome:":
                    rsp[rspCount] = this.getName();
                    break;
                case "email:":
                    rsp[rspCount] = this.getEmail();
                    break;
                case "contato:":
                    rsp[rspCount] = this.getContact();
                    break;
                case "endereco:":
                    rsp[rspCount] = this.getAddress();
                    break;
                case "cpf:":
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
    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
}
