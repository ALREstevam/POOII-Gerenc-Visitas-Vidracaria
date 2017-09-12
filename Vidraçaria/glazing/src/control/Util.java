package control;

import java.util.Date;
import persons.Driver;
import visit.Vehicle;

public class Util {

	/**
	 *  
	 */
	public boolean isVisitPossible(Driver driver, Date start, Date finish) {
		return false;
	}

	/**
	 *  
	 */
	public boolean canDriveVehicle(Driver driver, Vehicle vehicle) {
		if(driver.getDriverLicenseType() >= vehicle.getLicenseNeeded()){
                    return true;
                }
                return false;
	}

	/**
	 *  
	 */
	public void calcutateTotalTimeOfVisit(Date start, Date finish, Date timeToArrive, Date timeToComeBack, Date additional) {

	}

}
