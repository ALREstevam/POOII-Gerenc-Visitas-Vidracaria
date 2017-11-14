package persons;

import agenda.neow.agenda.Agenda;
import java.io.Serializable;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;
import visit.Visit;

public class Draftsman extends Driver implements Serializable, Descriptible, Arrayable{

    public Draftsman(int driverLicenseType, int personalNumber, int registration, String name, String email, String contact, Agenda agd) {
        super(driverLicenseType, personalNumber, registration, name, email, contact, agd);
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
                case "carteira:":
                    rsp[rspCount] = this.getDriverLicenseType();
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
}
