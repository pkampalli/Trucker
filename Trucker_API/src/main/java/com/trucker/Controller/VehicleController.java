package com.trucker.Controller;

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
	public void updateEmployee(@RequestBody Vehicle[] vehicles){
		for(Vehicle vehicle:vehicles)
			service.putVehicle(vehicle);
	}

}
