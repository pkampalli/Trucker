package com.trucker.entityPack;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {

	@Id
	String vin;
	
	String make;
	String model;
	int year;
	int redlineRpm;
	int maxFuelVolume;
	Date lastServiceDate;
	
	public Vehicle() {
		super();
	}

	public Vehicle(String vin, String make, String model, int makeYear, int redLineRpm, int maxFuelVolume,
			Date lastServiceDate) {
		//super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = makeYear;
		this.redlineRpm = redLineRpm;
		this.maxFuelVolume = maxFuelVolume;
		this.lastServiceDate = lastServiceDate;
	}
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getMakeYear() {
		return year;
	}
	public void setMakeYear(int makeYear) {
		this.year = makeYear;
	}
	public int getRedLineRpm() {
		return redlineRpm;
	}
	public void setRedLineRpm(int redLineRpm) {
		this.redlineRpm = redLineRpm;
	}
	public int getMaxFuelVolume() {
		return maxFuelVolume;
	}
	public void setMaxFuelVolume(int maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}
	public Date getLastServiceDate() {
		return lastServiceDate;
	}
	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	@Override
	public String toString() {
		return "Vehicle [vin=" + vin + ", make=" + make + ", model=" + model + ", makeYear=" + year
				+ ", redLineRpm=" + redlineRpm + ", maxFuelVolume=" + maxFuelVolume + ", lastServiceDate="
				+ lastServiceDate + "]";
	}
	
	
}
