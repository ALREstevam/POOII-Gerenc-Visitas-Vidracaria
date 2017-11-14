package visit;

import java.io.Serializable;
import java.util.List;
import agenda.neow.agenda.Agenda;

public class Vehicle implements Serializable, view.comboboxModel.Descriptible, view.tableModel.Arrayable {

   

    public enum licenseTypes {
        A, B, C, D;

        public static licenseTypes getFromName(String name) {
            for (licenseTypes type : licenseTypes.values()) {
                if (type.toString().equals(name)) {
                    return type;
                }
            }
            return licenseTypes.A;
        }
    }

    public enum vehicleTypes {
        MOTORCYCLE, CAR, TRUCK;

        public static vehicleTypes getFromName(String name) {
            for (vehicleTypes type : vehicleTypes.values()) {
                if (type.toString().equals(name)) {
                    return type;
                }
            }
            return vehicleTypes.MOTORCYCLE;
        }
    }

    private licenseTypes licence;
    private vehicleTypes vehType;
    private String registration;
    private String info;
    private Agenda agd;

    /**
     * Instantiates a new vechicle
     *
     * @param licence the license that the person driving the vehicle must have to do so (in the Brazilian standard)
     * @param vehType an type of vehicle
     * @param registeation vehicle's plate in the Brazilian standard
     * @param agd an agenda
     * @param info an information field
     */
    public Vehicle(licenseTypes licence, vehicleTypes vehType, String registeation, String info, Agenda agd) {
        this.licence = licence;
        this.vehType = vehType;
        this.registration = registeation;
        this.info = info;
        this.agd = agd;
    }

    public licenseTypes getLicenseNeeded() {
        return this.licence;
    }

    /**
     * A string representing the vehicle's plate in the Brazilian standard
     *
     * @return a registration
     */
    public String getRegistration() {
        return this.registration;
    }

    /**
     * A string representing the vehicle's plate in the Brazilian standard
     *
     * @param registration a registration
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
        return this.info + sep + this.vehType.toString() + sep + this.registration + sep + this.licence.toString();
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
                    rsp[rspCount] = this.vehType.toString();
                    break;
                case "placa":
                    rsp[rspCount] = this.registration;
                    break;
                case "carteira":
                    rsp[rspCount] = this.licence.toString();
                    break;
                default:
                    rsp[rspCount] = "";
                    break;
            }
            rspCount++;
        }
        return rsp;
    }

    @Override
    public Object setValue(String variable, Object value) {
        switch (variable) {
            case "info":
                this.info = (String) value;
                break;
            case "tipo":
                this.vehType = vehicleTypes.getFromName((String) value);
                break;
            case "placa":
                this.registration = (String) value;
                break;
            case "carteira":
                this.licence = licenseTypes.getFromName((String) value);
                break;
            default:
                break;
        }
        return this;
    }

     public licenseTypes getLicence() {
        return licence;
    }

    public vehicleTypes getVehType() {
        return vehType;
    }

    public Agenda getAgd() {
        return agd;
    }
    
}
