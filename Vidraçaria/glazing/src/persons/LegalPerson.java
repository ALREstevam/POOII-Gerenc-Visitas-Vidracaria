package persons;

import java.io.Serializable;

public class LegalPerson extends Client implements Serializable{

    private int cnpj;
    private int companyType;
    private int conpanyDescription;

    public LegalPerson(int cnpj, int companyType, int conpanyDescription, String address, String name, String email, String contact) {
        super(address, name, email, contact);
        this.cnpj = cnpj;
        this.companyType = companyType;
        this.conpanyDescription = conpanyDescription;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public int getCompanyType() {
        return companyType;
    }

    public void setCompanyType(int companyType) {
        this.companyType = companyType;
    }

    public int getConpanyDescription() {
        return conpanyDescription;
    }

    public void setConpanyDescription(int conpanyDescription) {
        this.conpanyDescription = conpanyDescription;
    }

}
