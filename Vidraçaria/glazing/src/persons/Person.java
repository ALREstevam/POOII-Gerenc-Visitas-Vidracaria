package persons;

import java.io.Serializable;
import view.comboboxModel.Descriptible;

/**
 * This is the abstract Person class. This class represents a group of people
 * who make up the showroom, such as clients and employees. These classes are
 * derived from the Person class
 * @author Pedro
 */
public abstract class Person implements Serializable, Descriptible{

	private String name;
	private String email;
	private String contact;

    /**
     * This is the constructor of the abstract Person class. This constructor
     * has three parameters
     * @param name
     * @param email
     * @param contact
     */
    public Person(String name, String email, String contact) {
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

    /**
     * This is another constructor of the abstract Person class. This 
     * constructor has one parameter
     * @param name
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * This method get the Person's name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * This method set the Employee's personalNumber
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method get the Person's email
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method set the Person's email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method get the Person's contact
     * @return String
     */
    public String getContact() {
        return contact;
    }

    /**
     * This method set the Person's contact
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }
}