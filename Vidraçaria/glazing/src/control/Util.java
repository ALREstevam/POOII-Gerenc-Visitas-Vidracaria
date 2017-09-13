package control;

import java.util.Date;
import persons.Driver;
import visit.Vehicle;

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

	/**
         * 
         * @param start
         * @param finish
         * @param timeToArrive
         * @param timeToComeBack
         * @param additional 
         * @return The sum of the given times in minutes
         */
	public int calcutateTotalTimeOfVisit(Date start, Date finish, Date timeToArrive, Date timeToComeBack, Date additional) {
                throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

}
