package com.trucker.entityPack;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Tires {
	
	@Id
	private String tiresId;
	
	private double frontLeft;
	private double frontRight;
	private double rearLeft;
	private double rearRight;
	
	@OneToOne(mappedBy = "tires")
	private Reading reading;
	
	public Tires() {
		super();
		this.tiresId=UUID.randomUUID().toString();
	}
		
	public Tires(double frontLeft, double frontRight, double rearLeft, double rearRight) {
		this.frontLeft = frontLeft;
		this.frontRight = frontRight;
		this.rearLeft = rearLeft;
		this.rearRight = rearRight;
	}
	
	public String getTiresId() {
		return tiresId;
	}

	public void setTiresId(String tiresId) {
		this.tiresId = tiresId;
	}

	public double getFrontLeft() {
		return frontLeft;
	}
	public void setFrontLeft(int frontLeft) {
		this.frontLeft = frontLeft;
	}
	public double getFrontRight() {
		return frontRight;
	}
	public void setFrontRight(int frontRight) {
		this.frontRight = frontRight;
	}
	public double getRearLeft() {
		return rearLeft;
	}
	public void setRearLeft(int rearLeft) {
		this.rearLeft = rearLeft;
	}
	public double getRearRight() {
		return rearRight;
	}
	public void setRearRight(int rearRight) {
		this.rearRight = rearRight;
	}
	
	

}
