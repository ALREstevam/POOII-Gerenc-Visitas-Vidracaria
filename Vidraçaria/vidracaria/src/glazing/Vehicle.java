/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glazing;

/**
 *
 * @author andre
 */
public class Vehicle {
    //ATTRIBUTES
    public enum vehicleTypes{
        pickup, miniVan, van, truck,
    }
    
    private vehicleTypes type;
    private String vehicleRegistrationPlate;
    private String color;
    private String chassisNumber;

    
    //CONSTRUCTOR
    public Vehicle(vehicleTypes type, String vehicleRegistrationPlate, String color, String chassisNumber) {
        this.type = type;
        this.vehicleRegistrationPlate = vehicleRegistrationPlate;
        this.color = color;
        this.chassisNumber = chassisNumber;
    }
    
    //GETTERS AND SETTERS
    public vehicleTypes getType() {
        return type;
    }

    public void setType(vehicleTypes type) {
        this.type = type;
    }

    public String getVehicleRegistrationPlate() {
        return vehicleRegistrationPlate;
    }

    public void setVehicleRegistrationPlate(String vehicleRegistrationPlate) {
        this.vehicleRegistrationPlate = vehicleRegistrationPlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }
}
