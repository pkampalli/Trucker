package com.trucker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trucker.Service.AlertService;
import com.trucker.entityPack.Alert;

@RestController
@ResponseBody
public class AlertController {

	@Autowired
	private AlertService service;
	
	@RequestMapping(method=RequestMethod.GET, value="/alerts/high")
	public List<Alert> getAllHighAlerts(){
		return service.getAllHighAlerts();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/alerts/{vin}")
	public List<Alert> getAllAlertsOfVehicle(@PathVariable("vin") String vin){
		return service.getAllAlertsOfVehicle(vin);
	}
	
}
