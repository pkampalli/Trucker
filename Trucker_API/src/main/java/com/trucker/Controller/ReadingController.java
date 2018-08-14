package com.trucker.Controller;

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

import com.trucker.Service.ReadingService;
import com.trucker.entityPack.Coordinates;
import com.trucker.entityPack.Reading;

@RestController
@ResponseBody
public class ReadingController {

	@Autowired
	private ReadingService service;
	
	
	@CrossOrigin(origins = "http://mocker.egen.io")
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value="/readings")
	public void postReadings(@RequestBody Reading reading){
		//for(Reading reading:readings)
			service.postReading(reading);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/location/{vin}")
	public List<Coordinates> getVehicleLocations(@PathVariable("vin") String vin){
		return service.getVehicleLocations(vin);
	}

}
