package control;

import java.time.LocalDateTime;
import persons.Driver;
import visit.Vehicle;
import java.time.Instant;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.ChronoUnit;
import javafx.util.converter.LocalDateTimeStringConverter;
import my.time.helper.DateTimeInterval;

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

	public DateTimeInterval calcutateTotalTimeOfVisit(LocalDateTime reference, int... minutes) {
            //DateTimeInterval dtrsp = new DateTimeInterval(reference, reference)
            
            int sum = 0;
            
            for(int value : minutes){
                sum += value;
            }
            
            LocalDateTime aDateTime = LocalDateTime.of(reference.get);

            
        }

}
