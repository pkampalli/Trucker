package com.trucker.entityPack;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	
	@NamedQuery(name="Alert.getByVin", query="SELECT alert FROM Alert alert WHERE alert.vin=:paramVin")
})
public class Alert {

	@Id
	private String alertId;
	
	private String vin;
	private AlertPriority priority;
	private String cause;
	private Date timestamp;
	
	public Alert() {
		this.alertId = UUID.randomUUID().toString();
	}
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public AlertPriority getPriority() {
		return priority;
	}
	public void setPriority(AlertPriority priority) {
		this.priority = priority;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	
	
}
