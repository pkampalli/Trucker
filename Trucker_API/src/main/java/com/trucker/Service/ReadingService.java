package com.trucker.Service;

import java.util.List;

import com.trucker.entityPack.Coordinates;
import com.trucker.entityPack.Reading;

public interface ReadingService {

	Reading postReading(Reading reading);
	List<Coordinates> getVehicleLocations(String vin);
	
}
