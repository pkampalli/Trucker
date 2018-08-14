package com.trucker.Repository;

import java.util.List;

import com.trucker.entityPack.Alert;

public interface AlertRepository {
	
	Alert saveAlert(Alert alert);
	List<Alert> getAllHighAlerts();
	List<Alert> getAllAlertsOfVehicle(String vin);
}
