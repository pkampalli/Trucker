package com.trucker.Repository;

import com.trucker.entityPack.Reading;
import com.trucker.entityPack.Vehicle;

public interface VehicleRepository {

	Vehicle putVehicle(Vehicle vehicle);
	Reading postReading(Reading reading);
	
}
