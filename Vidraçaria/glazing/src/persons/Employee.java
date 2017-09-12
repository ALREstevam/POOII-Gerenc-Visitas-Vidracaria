package persons;

import visit.Visit;

public abstract class Employee extends Person {

	private int personalNumber;
	private int registration;

    public Employee(int personalNumber, int registration, String name, String email, String contact) {
        super(name, email, contact);
        this.personalNumber = personalNumber;
        this.registration = registration;
    }

    public Employee(int personalNumber, int registration, String name) {
        super(name);
        this.personalNumber = personalNumber;
        this.registration = registration;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }

    public int getRegistration() {
        return registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }
}