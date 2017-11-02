package persons;

import java.io.Serializable;
import java.util.List;
import my.time.agenda.AgendaAllocator;
import my.time.helper.NoWorkPattern;
import visit.Vehicle;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

public class Driver extends Employee implements Serializable, my.time.Schedulable, Descriptible, Arrayable{
    private List<AgendaAllocator<Employee>> agendas;
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
                this.driverLicenseType = 1;
                break;
            case B:
                this.driverLicenseType = 2;
                break;
            case C:
                this.driverLicenseType = 3;
                break;
            case D:
                this.driverLicenseType = 4;
                break;
        }
    }

    public List<AgendaAllocator<Employee>> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<AgendaAllocator<Employee>> agendas) {
        this.agendas = agendas;
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
    public AgendaAllocator getAgenda(int index) {
            return this.agendas.get(index);
    }

    @Override
    public List getAllAgendas() {
        return this.agendas;
    }

    @Override
    public NoWorkPattern getNoWorkPattern() {
        return this.myNoWorkPattern;
    }

    public void setMyNoWorkPattern(NoWorkPattern myNoWorkPattern) {
        this.myNoWorkPattern = myNoWorkPattern;
    }
    
}
