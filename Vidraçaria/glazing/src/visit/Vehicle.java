package visit;

import java.io.Serializable;
import java.util.List;
import agenda.neow.agenda.Agenda;

public class Vehicle implements Serializable, view.comboboxModel.Descriptible, view.tableModel.Arrayable {
    public enum licenseTypes {
        A, B, C, D
    }

    private int licenseNeeded;//The license can be used as a enum or a number
    private int type;
    private String registration;
    private String info;
    private Agenda agd;

    /**
     * Instantiates a new vechicle
     *
     * @param licenseNeeded the license that the person driving the vehicle must
     * have to do so (in the Brazilian standard)
     * @param type
     * @param registration vehicle's plate in the Brazilian standard
     * @param info
     */
    public Vehicle(int licenseNeeded, int type, String registration, String info, Agenda agd) {
        this.licenseNeeded = licenseNeeded;
        this.type = type;
        this.registration = registration;
        this.info = info;
    }

    public int getLicenseNeeded() {
        return this.licenseNeeded;
    }

    public void setLicenseNeeded(licenseTypes license) {
        switch (license) {
            case A:
                this.licenseNeeded = 1;
                break;
            case B:
                this.licenseNeeded = 2;
                break;
            case C:
                this.licenseNeeded = 3;
                break;
            case D:
                this.licenseNeeded = 4;
                break;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * A string representing the vehicle's plate in the Brazilian standard
     *
     * @return
     */
    public String getRegistration() {
        return registration;
    }

    /**
     * A string representing the vehicle's plate in the Brazilian standard
     *
     * @return
     */
    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String describe() {
        return this.info + sep + this.type + sep + this.registration + sep + this.licenseNeeded;
    }

    @Override
    public Object[] attributesToArray(String[] order) {
        Object[] rsp = new Object[4];

        int rspCount = 0;
        for (String s : order) {
            switch (s) {
                case "info":
                    rsp[rspCount] = this.info;
                    break;
                case "tipo":
                    rsp[rspCount] = this.type;
                    break;
                case "placa":
                    rsp[rspCount] = this.registration;
                    break;
                case "carteira":
                    rsp[rspCount] = this.licenseNeeded;
                    break;
                default:
                    rsp[rspCount] = "";
                    break;
            }
            rspCount++;
        }
        return rsp;
    }
}
