package persons;

import java.io.Serializable;
import java.util.List;
import my.time.agenda.AgendaAllocator;
import my.time.helper.NoWorkPattern;
import visit.Vehicle;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

public class Driver extends Employee implements Serializable, my.time.Schedulable, Descriptible, Arrayable{
    private AgendaAllocator<Employee> agenda;
    private NoWorkPattern myNoWorkPattern;
    private int driverLicenseType;
    

    public Driver(int driverLicenseType, int personalNumber, int registration, String name, String email, String contact) {
        super(personalNumber, registration, name, email, contact);
        this.driverLicenseType = driverLicenseType;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return this.describe();
    }

    @Override
    public NoWorkPattern getNoWorkPattern() {
        return this.getMyNoWorkPattern();
    }

    public void setMyNoWorkPattern(NoWorkPattern myNoWorkPattern) {
        this.myNoWorkPattern = myNoWorkPattern;
    }

    @Override
    public AgendaAllocator getAgenda() {
        return this.agenda;
    }

    /**
     * @param agenda the agenda to set
     */
    public void setAgenda(AgendaAllocator<Employee> agenda) {
        this.agenda = agenda;
    }

    /**
     * @return the myNoWorkPattern
     */
    public NoWorkPattern getMyNoWorkPattern() {
        return myNoWorkPattern;
    }

    /**
     * @param driverLicenseType the driverLicenseType to set
     */
    public void setDriverLicenseType(int driverLicenseType) {
        this.driverLicenseType = driverLicenseType;
    }
    
    
    
}
