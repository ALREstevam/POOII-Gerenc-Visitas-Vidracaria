package persons;

import java.io.Serializable;
import visit.Visit;

public class Assembler extends Driver implements Serializable, Cloneable{

    public Assembler(int driverLicenseType, int personalNumber, int registration, String name, String email, String contact) {
        super(driverLicenseType, personalNumber, registration, name, email, contact);
    }

    /**
     *
     */
    public void changeVisitStatus(Visit visit /*, visit Status*/) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

}
