package persons;

import visit.Visit;

public class Draftsman extends Driver {

    public Draftsman(int driverLicenseType, int personalNumber, int registration, String name, String email, String contact) {
        super(driverLicenseType, personalNumber, registration, name, email, contact);
    }

    /**
     *
     */
    public void appendProjectToVisit(Visit visit) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }
    
    

}
