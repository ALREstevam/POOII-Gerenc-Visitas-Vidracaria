package persons;

import agenda.neow.agenda.Agenda;
import java.io.Serializable;
import view.comboboxModel.Descriptible;
import visit.Visit;

public class Draftsman extends Driver implements Serializable, Descriptible{

    public Draftsman(int driverLicenseType, int personalNumber, int registration, String name, String email, String contact, Agenda agd) {
        super(driverLicenseType, personalNumber, registration, name, email, contact, agd);
    }
}
