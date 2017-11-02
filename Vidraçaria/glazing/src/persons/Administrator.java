package persons;

import java.io.Serializable;
import java.util.List;
import view.comboboxModel.Descriptible;

public class Administrator extends Employee implements Serializable, Descriptible{

    private String type;

    public String requestReport(List<visit.Visit> visits, List<Employee> employees, List<Client> client) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    public Administrator(String type, int personalNumber, int registration, String name, String email, String contact) {
        super(personalNumber, registration, name, email, contact);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String describe() {
        return "ADM" + sep + this.getName() + sep + this.getEmail();
    }

}
