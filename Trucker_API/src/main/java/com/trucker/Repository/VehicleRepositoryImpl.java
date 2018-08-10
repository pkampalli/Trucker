package com.trucker.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
