package persons;

import java.io.Serializable;
import view.comboboxModel.Descriptible;
import visit.Visit;

public class Draftsman extends Driver implements Serializable, Descriptible{

    public Draftsman(int driverLicenseType, int personalNumber, int registration, String name, String email, String contact) {
        super(driverLicenseType, personalNumber, registration, name, email, contact);
    }

    /**
     *
     */
    public void appendProjectToVisit(Visit visit) {
        
    }
    
    

}
