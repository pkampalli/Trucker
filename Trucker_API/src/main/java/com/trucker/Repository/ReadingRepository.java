package com.trucker.Repository;

import java.util.List;

import com.trucker.entityPack.Coordinates;
import com.trucker.entityPack.Reading;

public interface ReadingRepository {

	Reading postReading(Reading reading);
	List<Coordinates> getVehicleLocations(String vin);
	
}
