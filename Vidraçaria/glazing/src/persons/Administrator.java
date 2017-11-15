package persons;

import java.io.Serializable;
import java.util.List;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

/**
 * This class represents an administrator. This class is derived from Employee. 
 * @author Pedro
 */
public class Administrator extends Employee implements Serializable, Descriptible, Arrayable{

    private String type;


    /**
     * This is the constructor of the administrator class
     * @param type this is the type of Administrator
     * @param personalNumber this is the personalNumber of Administrator
     * @param registration this is the registration of Administrator
     * @param name this is the name of Administrator
     * @param email this is the email of Administrator
     * @param contact this is the contact of Administrator
     */
    public Administrator(String type, int personalNumber, int registration, String name, String email, String contact) {
        super(personalNumber, registration, name, email, contact);
        this.type = type;
    }

    /**
     * This method get the Administrator's type
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * This method set the Administrator's type
     * @param type this is the type of Administrator
     */
    public void setType(String type) {
        this.type = type;
    }

    
    @Override
    public String describe() { 
        this.describe();
        return "ADM" + sep + this.getName() + sep + this.getEmail();
    }

    @Override
    public Object[] attributesToArray(String[] order) {
        Object[] rsp = new Object[6];
        int rspCount = 0;
        for (String s : order) {
            switch (s) {
                case "nome":
                    rsp[rspCount] = this.getName();
                    break;
                case "email":
                    rsp[rspCount] = this.getEmail();
                    break;
                case "tipo":
                    rsp[rspCount] = this.getType();
                    break;
                case "contato":
                    rsp[rspCount] = this.getContact();
                    break;
                case "registro":
                    rsp[rspCount] = this.getRegistration();
                    break;
                case "telefone":
                    rsp[rspCount] = this.getPersonalNumber();
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
            case "tipo":
                this.setType((String) value);
                break;    
            case "contato":
                this.setContact((String) value);
                break;
            case "registro":
                this.setRegistration((int) value);
                break;
            case "telefone":
                this.setPersonalNumber((int) value);
                break;
                
            default:
                break;
        }
        return this;
    }
}
