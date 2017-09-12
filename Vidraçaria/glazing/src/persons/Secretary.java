package persons;

import java.util.List;
import visit.Vehicle;
import visit.Visit;

public class Secretary extends Employee {

    public Secretary(int personalNumber, int registration, String name, String email, String contact) {
        super(personalNumber, registration, name, email, contact);
    }

    /**
     *
     */
    public Visit markVisit(Visit visit, List<Driver> drivers, List<Vehicle> vehicles) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

}
