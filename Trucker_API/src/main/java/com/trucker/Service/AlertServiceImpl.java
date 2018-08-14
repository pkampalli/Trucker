package com.trucker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trucker.Repository.AlertRepository;
import com.trucker.entityPack.Alert;

@Service
public class AlertServiceImpl implements AlertService{

	@Autowired
	private AlertRepository repo;
	
	@Override
	@Transactional
	public List<Alert> getAllHighAlerts() {
		return repo.getAllHighAlerts();
	}

	@Override
	@Transactional
	public List<Alert> getAllAlertsOfVehicle(String vin) {
		return repo.getAllAlertsOfVehicle(vin);
	}

	
}
