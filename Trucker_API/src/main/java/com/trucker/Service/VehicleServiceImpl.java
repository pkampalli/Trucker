package com.trucker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trucker.Repository.VehicleRepository;
import com.trucker.entityPack.Reading;
import com.trucker.entityPack.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleRepository repo;
	
	@Override
	@Transactional
	public Vehicle putVehicle(Vehicle vehicle) {
		
		return repo.putVehicle(vehicle);
	}
	
	@Override
	@Transactional
	public Reading postReading(Reading reading){
		
		return repo.postReading(reading);
	}

}
