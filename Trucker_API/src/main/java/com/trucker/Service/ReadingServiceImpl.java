package com.trucker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trucker.Repository.AlertRepository;
import com.trucker.Repository.ReadingRepository;
import com.trucker.Repository.VehicleRepository;
import com.trucker.entityPack.Alert;
import com.trucker.entityPack.AlertPriority;
import com.trucker.entityPack.Coordinates;
import com.trucker.entityPack.Reading;
import com.trucker.entityPack.Tires;
import com.trucker.entityPack.Vehicle;

@Service
public class ReadingServiceImpl implements ReadingService{

	@Autowired
	private ReadingRepository repo;
	
	@Autowired
	private VehicleRepository vehRepo;
	
	@Autowired
	private AlertRepository alertRepo;

	
	@Override
	@Transactional
	public Reading postReading(Reading reading){
		Vehicle vehicle = vehRepo.getVehicleByVin(reading.getVin());
		Tires tires = reading.getTires();
		if(reading.getEngineRpm()>vehicle.getRedlineRpm()){
			Alert alert = new Alert();
			alert.setVin(reading.getVin());
			alert.setPriority(AlertPriority.HIGH);
			alert.setCause("Vehicle RPM > Redline RPM");
			alert.setTimestamp(reading.getTimestamp());
			alertRepo.saveAlert(alert);
		}
		
		if(reading.getFuelVolume()<(0.1*vehicle.getMaxFuelVolume())){
			Alert alert = new Alert();
			alert.setVin(reading.getVin());
			alert.setPriority(AlertPriority.MEDIUM);
			alert.setCause("Fuel less than 10%");
			alert.setTimestamp(reading.getTimestamp());
			alertRepo.saveAlert(alert);
		}
		
		if(tires.getFrontLeft()<32||tires.getFrontLeft()>36){
			Alert alert = new Alert();
			alert.setVin(reading.getVin());
			alert.setPriority(AlertPriority.LOW);
			alert.setCause("Unusual air pressure in front left tire");
			alert.setTimestamp(reading.getTimestamp());
			alertRepo.saveAlert(alert);
		}
		
		if(tires.getRearLeft()<32||tires.getRearLeft()>36){
			Alert alert = new Alert();
			alert.setVin(reading.getVin());
			alert.setPriority(AlertPriority.LOW);
			alert.setCause("Unusual air pressure in rear left tire");
			alert.setTimestamp(reading.getTimestamp());
			alertRepo.saveAlert(alert);
		}
		
		if(tires.getFrontRight()<32||tires.getFrontRight()>36){
			Alert alert = new Alert();
			alert.setVin(reading.getVin());
			alert.setPriority(AlertPriority.LOW);
			alert.setCause("Unusual air pressure in front right tire");
			alert.setTimestamp(reading.getTimestamp());
			alertRepo.saveAlert(alert);
		}
		
		if(tires.getRearRight()<32||tires.getRearRight()>36){
			Alert alert = new Alert();
			alert.setVin(reading.getVin());
			alert.setPriority(AlertPriority.LOW);
			alert.setCause("Unusual air pressure in rear right tire");
			alert.setTimestamp(reading.getTimestamp());
			alertRepo.saveAlert(alert);
		}
		
		if(reading.isCheckEngineLightOn()){
			Alert alert = new Alert();
			alert.setVin(reading.getVin());
			alert.setPriority(AlertPriority.LOW);
			alert.setCause("Check Engine Light On");
			alert.setTimestamp(reading.getTimestamp());
			alertRepo.saveAlert(alert);
		}
		
		if(reading.isEngineCoolantLow()){
			Alert alert = new Alert();
			alert.setVin(reading.getVin());
			alert.setPriority(AlertPriority.LOW);
			alert.setCause("Engine Coolant Low");
			alert.setTimestamp(reading.getTimestamp());
			alertRepo.saveAlert(alert);
		}
		return repo.postReading(reading);
	}


	@Override
	public List<Coordinates> getVehicleLocations(String vin) {
		return repo.getVehicleLocations(vin);
	}
}
