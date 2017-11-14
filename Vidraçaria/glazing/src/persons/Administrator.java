package persons;

import java.io.Serializable;
import java.util.List;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

public class Administrator extends Employee implements Serializable, Descriptible, Arrayable{

    private String type;

    public String requestReport(List<visit.Visit> visits, List<Employee> employees, List<Client> client) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    public Administrator(String type, int personalNumber, int registration, String name, String email, String contact) {
        super(personalNumber, registration, name, email, contact);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String describe() {
        return "ADM" + sep + this.getName() + sep + this.getEmail();
    }

    @Override
    public Object[] attributesToArray(String[] order) {
        Object[] rsp = new Object[6];
        int rspCount = 0;
        for (String s : order) {
            switch (s) {
                case "nome:":
                    rsp[rspCount] = this.getName();
                    break;
                case "email:":
                    rsp[rspCount] = this.getEmail();
                    break;
                case "tipo:":
                    rsp[rspCount] = this.getType();
                    break;
                case "contato:":
                    rsp[rspCount] = this.getContact();
                    break;
                case "registro:":
                    rsp[rspCount] = this.getRegistration();
                    break;
                case "telefone:":
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
