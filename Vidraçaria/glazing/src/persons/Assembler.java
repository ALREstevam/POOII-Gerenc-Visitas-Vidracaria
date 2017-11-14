package persons;

import java.io.Serializable;
import visit.Visit;
import agenda.neow.agenda.Agenda;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

/**
 * This class is an Assembler derived from Driver class
 * @author Pedro
 */
public class Assembler extends Driver implements Serializable, Cloneable, Descriptible, Arrayable{

    /**
     * This is the constructor of the Assembler class
     * @param driverLicenseType
     * @param personalNumber
     * @param registration
     * @param name
     * @param email
     * @param contact
     * @param agd
     */
    public Assembler(licenseTypes driverLicenseType, int personalNumber, int registration, String name, String email, String contact, Agenda agd) {
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
    @Override
        public Object setValue(String variable, Object value) {
        switch (variable) {
            case "nome":
                this.setName((String) value);
                break;
            case "email":
                this.setEmail((String) value);
                break;
            case "carteira":
                this.setDriverLicenseType(licenseTypes.getFromName((String) value));
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
