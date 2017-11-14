package persons;

import java.io.Serializable;
import view.comboboxModel.Descriptible;

/**
 *  This is the abstract Employee class, derived from the Person class
 * @author Pedro
 */
public abstract class Employee extends Person implements Serializable, Descriptible{

	private int personalNumber;
	private int registration;

    /**
     * This is the constructor of the abstract Employee class. This constructor
     * has five parameters
     * @param personalNumber
     * @param registration
     * @param name
     * @param email
     * @param contact
     */
    public Employee(int personalNumber, int registration, String name, String email, String contact) {
        super(name, email, contact);
        this.personalNumber = personalNumber;
        this.registration = registration;
    }

    /**
     * This is another constructor of the abstract Employee class. This 
     * constructor has three parameters
     * @param personalNumber
     * @param registration
     * @param name
     */
    public Employee(int personalNumber, int registration, String name) {
        super(name);
        this.personalNumber = personalNumber;
        this.registration = registration;
    }

    /**
     * This method get the Employee's personalNumber
     * @return int
     */
    public int getPersonalNumber() {
        return personalNumber;
    }

    /**
     * This method set the Employee's personalNumber
     * @param personalNumber
     */
    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }

    /**
     * This method get the Employee's registration
     * @return int
     */
    public int getRegistration() {
        return registration;
    }

    /**
     * This method set the Employee's registration
     * @param registration
     */
    public void setRegistration(int registration) {
        this.registration = registration;
    }
}