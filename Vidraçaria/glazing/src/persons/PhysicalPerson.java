package persons;

public class PhysicalPerson extends Client {

    private int cpf;

    public PhysicalPerson(int cpf, String address, String name, String email, String contact) {
        super(address, name, email, contact);
        this.cpf = cpf;
    }

    
}
