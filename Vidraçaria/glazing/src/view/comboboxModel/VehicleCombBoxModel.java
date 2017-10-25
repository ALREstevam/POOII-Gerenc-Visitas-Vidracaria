/*
 * To change this license header, choose License Headers in Vehicle Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.comboboxModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import visit.Vehicle;

/**
 *
 * @author andre
 */
public class VehicleCombBoxModel {
    private DefaultComboBoxModel getComboBoxModel(List<Vehicle> vehicles){
        List<String> vehiclesInfo = new ArrayList<>(vehicles.size());
        
        for(Vehicle veh : vehicles){
            vehiclesInfo.add(veh.getRegistration() + " | " + veh.getInfo() + " | Carteira: " + veh.getLicenseNeeded());
        }
        return new DefaultComboBoxModel(vehiclesInfo.toArray());
    }
}
