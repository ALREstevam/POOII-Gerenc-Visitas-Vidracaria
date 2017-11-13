package persons;

import java.io.Serializable;
import java.util.List;
import visit.Vehicle;
import visit.Visit;
import agenda.neow.agenda.Agenda;

public class Secretary extends Employee implements Serializable, Cloneable{

    public Secretary(int personalNumber, int registration, String name, String email, String contact) {
        super(personalNumber, registration, name, email, contact);
    }

    public void markVisit(List<Driver> drivers, List<Vehicle> vehicles){

    }

    @Override
    public String describe() {
        return "SEC" + sep + this.getName() + sep + this.getEmail();
    }

}
