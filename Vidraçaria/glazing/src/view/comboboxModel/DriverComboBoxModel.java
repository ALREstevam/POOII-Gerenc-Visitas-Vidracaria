/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.comboboxModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import persons.Driver;

/**
 *
 * @author andre
 */
public class DriverComboBoxModel {
    private DefaultComboBoxModel getComboBoxModel(List<Driver> drivers){
        List<String> driversInfo = new ArrayList<>(drivers.size());
        
        for(Driver driver : drivers){
            driversInfo.add(driver.getRegistration() + " | " + driver.getName() + " | " + driver.getEmail() + " | Carta: " + driver.getDriverLicenseType());
        }
        return new DefaultComboBoxModel(driversInfo.toArray());
    }
}
