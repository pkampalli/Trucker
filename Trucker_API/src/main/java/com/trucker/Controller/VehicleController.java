package com.trucker.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trucker.Service.VehicleService;
import com.trucker.entityPack.Vehicle;

@RestController
@ResponseBody
public class VehicleController {
	
	@Autowired
	private VehicleService service;
	
	@CrossOrigin(origins = "http://mocker.egen.io")
	@RequestMapping(method=RequestMethod.PUT, value="/vehicles")
	public List<Vehicle> putVehicles(@RequestBody Vehicle[] vehicles){
		List<Vehicle> result = new ArrayList<Vehicle>();
		for(Vehicle vehicle:vehicles)
			result.add(service.putVehicle(vehicle));
	
	return result;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/vehicles/{vin}")
	public Vehicle getVehicleByVin(@PathVariable("vin") String vin){
		
			Vehicle vehicle = service.getVehicleByVin(vin);
	
	return vehicle;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/vehicles")
	public List<Vehicle> getAllVehicles(){
		return service.getAllVehicles();
	}
	

}
