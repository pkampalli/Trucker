package com.trucker.Service;

import com.trucker.entityPack.Reading;
import com.trucker.entityPack.Vehicle;

public interface VehicleService {

	Vehicle putVehicle(Vehicle vehicle);
	Reading postReading(Reading reading);
}
