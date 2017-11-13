package util;

import java.time.LocalDateTime;
import persons.Driver;
import visit.Vehicle;
import java.time.Instant;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.ChronoUnit;
import javafx.util.converter.LocalDateTimeStringConverter;

public class Util {

	/**
         * 
         * @param driver
         * @param vehicle
         * @return {@code true} if the driver has the needed license to drive the vehicle
         */
	public boolean canDriveVehicle(Driver driver, Vehicle vehicle) {
		if(driver.getDriverLicenseType() >= vehicle.getLicenseNeeded()){
                    return true;
                }
                return false;
	}
        
        
        public static String portugueesePlurarize(int amount, String str){
            return (amount == 1)?str:str+"s";
        }

}
