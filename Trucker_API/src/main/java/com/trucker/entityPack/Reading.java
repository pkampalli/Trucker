package com.trucker.entityPack;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reading {

	@Id
	private String readingId;
	
	private String vin;
	private double latitude;
	private double longitude;
	private Date timestamp;
	private float fuelVolume;
	private double speed;
	private double engineHp;
	private boolean checkEngineLightOn;
	private boolean engineCoolantLow;
	private boolean cruiseControlOn;
	private double engineRpm;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tiresId")
	private Tires tires;
	
	public Reading() {
		this.readingId = UUID.randomUUID().toString();
	}
	
	public Reading(String vin, double latitude, double longitude, Date timestamp, float fuelVolume, double speed,
			double engineHp, boolean checkEngineLightOn, boolean engineCoolantLow, boolean cruiseControlOn, double engineRpm,
			Tires tires) {
		this.vin = vin;
		this.latitude = latitude;
		this.longitude = longitude;
		this.timestamp = timestamp;
		this.fuelVolume = fuelVolume;
		this.speed = speed;
		this.engineHp = engineHp;
		this.checkEngineLightOn = checkEngineLightOn;
		this.engineCoolantLow = engineCoolantLow;
		this.cruiseControlOn = cruiseControlOn;
		this.engineRpm = engineRpm;
		this.tires = tires;
	}
	
	public String getId() {
		return readingId;
	}

	public void setId(String id) {
		this.readingId = id;
	}

	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public float getFuelVolume() {
		return fuelVolume;
	}
	public void setFuelVolume(float fuelVolume) {
		this.fuelVolume = fuelVolume;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getEngineHp() {
		return engineHp;
	}
	public void setEngineHp(int engineHp) {
		this.engineHp = engineHp;
	}
	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}
	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}
	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}
	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}
	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}
	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}
	public double getEngineRpm() {
		return engineRpm;
	}
	public void setEngineRpm(int engineRpm) {
		this.engineRpm = engineRpm;
	}
	public Tires getTires() {
		return tires;
	}
	public void setTires(Tires tires) {
		this.tires = tires;
	}

	@Override
	public String toString() {
		return "Reading [vin=" + vin + ", latitude=" + latitude + ", longitude=" + longitude + ", timestamp="
				+ timestamp + ", fuelVolume=" + fuelVolume + ", speed=" + speed + ", engineHp=" + engineHp
				+ ", checkEngineLightOn=" + checkEngineLightOn + ", engineCoolantLow=" + engineCoolantLow
				+ ", cruiseControlOn=" + cruiseControlOn + ", engineRpm=" + engineRpm + ", tires=" + tires + "]";
	}
	
	
}
