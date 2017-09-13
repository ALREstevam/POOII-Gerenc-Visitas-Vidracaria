package visit;

import timeHlp.Agenda;

public class Vehicle {
    public enum licenseTypes{A, B, C, D}

	private int licenseNeeded;
	private int type;
	private String registration;
	private String info;
        private Agenda agenda;

    public Vehicle(int licenseNeeded, String registration) {
        this.licenseNeeded = licenseNeeded;
        this.registration = registration;
        this.agenda = new Agenda(30, 10);
    }
    
    
    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
    
    public int getLicenseNeeded() {
        return this.licenseNeeded;
    }

    public void setLicenseNeeded(licenseTypes license) {
        switch(license){
            case A:
                this.licenseNeeded = 1;
                break;
            case B:
                this.licenseNeeded = 2;
                break;
            case C:
                this.licenseNeeded = 3;
                break;
            case D:
                this.licenseNeeded = 4;
                break;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
