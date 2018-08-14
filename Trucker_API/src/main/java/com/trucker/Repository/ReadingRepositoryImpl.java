package com.trucker.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.trucker.entityPack.Coordinates;
import com.trucker.entityPack.Reading;


@Repository
public class ReadingRepositoryImpl implements ReadingRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Reading postReading(Reading reading) {
		em.persist(reading);
		return reading;
	}

	@Override
	public List<Coordinates> getVehicleLocations(String vin) {
		TypedQuery<Reading> query = em.createNamedQuery("Reading.getVehicleLocations", Reading.class);
		query.setParameter("paramVin", vin);
		List<Reading> list = query.getResultList();
		if(list.size()>=1){
			List<Coordinates> coordList= new ArrayList<Coordinates>();
			for(Reading reading: list){
				Coordinates coordinate = new Coordinates();
				coordinate.setLatitude(reading.getLatitude());
				coordinate.setLongitude(reading.getLongitude());
				coordinate.setTimestamp(reading.getTimestamp());
				coordList.add(coordinate);
			}
			
			return coordList;
		}
		else return null;
	}

}
