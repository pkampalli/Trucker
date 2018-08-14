package com.trucker.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.trucker.entityPack.Vehicle;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Vehicle putVehicle(Vehicle vehicle) {
		return em.merge(vehicle);
	}

	@Override
	public Vehicle getVehicleByVin(String vin) {
		//return em.find(Vehicle.class, vin);
		TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findByVin", Vehicle.class);
		query.setParameter("paramVin", vin);
		List<Vehicle> list = query.getResultList();
		if(list.size()==1 && list!=null) return list.get(0);
		else return null;
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		TypedQuery<Vehicle> query = em.createQuery("SELECT vehicle FROM Vehicle vehicle", Vehicle.class);
		return query.getResultList();
	}

	

}
