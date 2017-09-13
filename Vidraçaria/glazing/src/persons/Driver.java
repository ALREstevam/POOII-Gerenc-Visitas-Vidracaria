package persons;

import timeHlp.Agenda;
import visit.Vehicle;

public class Driver extends Employee {
    private timeHlp.Agenda agenda;
    private int driverLicenseType;

    public Driver(int driverLicenseType, int personalNumber, int registration, String name, String email, String contact) {
        super(personalNumber, registration, name, email, contact);
        this.driverLicenseType = driverLicenseType;
        this.agenda = new Agenda(5000, 10);
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

    public timeHlp.Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(timeHlp.Agenda agenda) {
        this.agenda = agenda;
    }
    
    

}
