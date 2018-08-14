package com.trucker.Service;

import java.util.List;

import com.trucker.entityPack.Vehicle;

public interface VehicleService {

	Vehicle putVehicle(Vehicle vehicle);

	Vehicle getVehicleByVin(String vin);
	
	List<Vehicle> getAllVehicles();
}
