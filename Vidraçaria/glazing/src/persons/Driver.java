package persons;

import java.io.Serializable;
import agenda.neow.agenda.Agenda;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;
import visit.Vehicle;

public class Driver extends Employee implements Serializable, Descriptible, Arrayable{
    private Agenda agd;
    private int driverLicenseType;
    

    public Driver(int driverLicenseType, int personalNumber, int registration, String name, String email, String contact, Agenda agd) {
        super(personalNumber, registration, name, email, contact);
        this.driverLicenseType = driverLicenseType;
        this.agd = agd;
        //this.agenda = new Agenda(5000, 10);
    }

    public int getDriverLicenseType() {
        return driverLicenseType;
    }

    public void setDriverLicenseType(Vehicle.licenseTypes license) {
        switch (license) {
            case A:
                this.setDriverLicenseType(1);
                break;
            case B:
                this.setDriverLicenseType(2);
                break;
            case C:
                this.setDriverLicenseType(3);
                break;
            case D:
                this.setDriverLicenseType(4);
                break;
        }
    }

    @Override
    public String describe() {
        return "DRV" + sep + this.getName() + sep + this.getEmail();
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
    public String toString() {
        return this.describe();
    }

    /**
     * @param driverLicenseType the driverLicenseType to set
     */
    public void setDriverLicenseType(int driverLicenseType) {
        this.driverLicenseType = driverLicenseType;
    }
    
    

    @Override
    public Object setValue(String variable, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Agenda getAgd() {
        return agd;
    }
    
    
    
}
