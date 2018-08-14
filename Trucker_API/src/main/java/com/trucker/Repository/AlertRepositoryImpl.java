package com.trucker.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.trucker.entityPack.Alert;

@Repository
public class AlertRepositoryImpl implements AlertRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Alert saveAlert(Alert alert) {
		em.persist(alert);
		return alert;
	}

	@Override
	public List<Alert> getAllHighAlerts() {
		String queryStmt = "SELECT alert FROM Alert alert WHERE alert.priority=2 AND "+
					"TIMESTAMPDIFF(minute,alert.timestamp,NOW()) < 120 ORDER BY  alert.timestamp";
		TypedQuery<Alert> query = em.createQuery(queryStmt, Alert.class);
		return query.getResultList();
	}

	@Override
	public List<Alert> getAllAlertsOfVehicle(String vin) {
		TypedQuery<Alert> query = em.createNamedQuery("Alert.getByVin", Alert.class);
		query.setParameter("paramVin", vin);
		List<Alert> list = query.getResultList();
		if(list.size()>=1) return query.getResultList();
		else return null;
	}

}
