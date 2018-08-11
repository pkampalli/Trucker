package com.trucker.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trucker.Service.VehicleService;
import com.trucker.entityPack.Reading;
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
	
	@CrossOrigin(origins = "http://mocker.egen.io")
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value="/readings")
	public void postReadings(@RequestBody Reading reading){
		//for(Reading reading:readings)
			service.postReading(reading);
	}

}
