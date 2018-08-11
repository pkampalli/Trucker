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
	double year;
	double redlineRpm;
	double maxFuelVolume;
	Date lastServiceDate;
	
	public Vehicle() {
		
	}

	public Vehicle(String vin, String make, String model, double year, double redlineRpm, double maxFuelVolume,
			Date lastServiceDate) {
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.redlineRpm = redlineRpm;
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
	public double getYear() {
		return year;
	}
	public void setYear(double year) {
		this.year = year;
	}
	public double getRedlineRpm() {
		return redlineRpm;
	}
	public void setRedlineRpm(double redlineRpm) {
		this.redlineRpm = redlineRpm;
	}
	public double getMaxFuelVolume() {
		return maxFuelVolume;
	}
	public void setMaxFuelVolume(double maxFuelVolume) {
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
