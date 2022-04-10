package com.zenbaei.drones.drone;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;

import com.zenbaei.drones.medication.Medication;

@Entity
public class Drone {
	@Id
	@GeneratedValue
	private Long id;
	
	@Length(max = 100)
	private String serial;
	
	@Max(500)
	private Double weightLimit;
	
	private Model model;
	
	private Status status;
	
	private Integer battery;
	
	@OneToMany(mappedBy = "drone")
	private List<Medication> medications;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public Double getWeightLimit() {
		return weightLimit;
	}
	
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Integer getBattery() {
		return battery;
	}
	public void setBattery(Integer battery) {
		this.battery = battery;
	}
	public List<Medication> getMedications() {
		return medications;
	}
	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}	
	
	public enum Model {
		LIGHT_WEIGHT,
		MIDDLE_WEIGHT,
		CRUISER_WEIGHT,
		HEAVY_WEIGHT,
	}

	public enum Status {
		IDLE, 
		LOADING, 
		LOADED, 
		DELIVERING, 
		DELIVERED, 
		RETURNING
	}
}


