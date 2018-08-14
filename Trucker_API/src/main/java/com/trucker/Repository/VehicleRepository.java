package com.trucker.Repository;

import java.util.List;

import com.trucker.entityPack.Vehicle;

public interface VehicleRepository {

	Vehicle putVehicle(Vehicle vehicle);
	Vehicle getVehicleByVin(String vin);
	List<Vehicle> getAllVehicles();
}
