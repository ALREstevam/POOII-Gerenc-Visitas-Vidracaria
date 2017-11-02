package persons;

import java.io.Serializable;

public class LegalPerson extends Client implements Serializable, Cloneable{

    private int cnpj;
    private String companyType;
    private String conpanyDescription;

    public LegalPerson(int cnpj, String companyType, String conpanyDescription, String address, String name, String email, String contact) {
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

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getConpanyDescription() {
        return conpanyDescription;
    }

    public void setConpanyDescription(String conpanyDescription) {
        this.conpanyDescription = conpanyDescription;
    }

    @Override
    public String describe() {
        return this.getName() + sep + this.getEmail() + sep + this.cnpj;
    }

}
