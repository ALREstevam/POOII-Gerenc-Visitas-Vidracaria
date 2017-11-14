package persons;

import java.io.Serializable;
import java.util.List;
import visit.Vehicle;
import visit.Visit;
import agenda.neow.agenda.Agenda;
import view.tableModel.Arrayable;

public class Secretary extends Employee implements Serializable, Cloneable, Arrayable{

    public Secretary(int personalNumber, int registration, String name, String email, String contact) {
        super(personalNumber, registration, name, email, contact);
    }

    public void markVisit(List<Driver> drivers, List<Vehicle> vehicles){

    }

    @Override
    public String describe() {
        return "SEC" + sep + this.getName() + sep + this.getEmail();
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
                case "registro:":
                    rsp[rspCount] = this.getRegistration();
                    break;
                case "numeroPessoa:":
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
