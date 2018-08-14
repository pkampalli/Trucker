package com.trucker.Service;

import java.util.List;

import com.trucker.entityPack.Alert;

public interface AlertService {
	List<Alert> getAllHighAlerts();
	List<Alert> getAllAlertsOfVehicle(String vin);
}
