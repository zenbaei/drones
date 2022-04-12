package com.zenbaei.drones.domain.drone.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zenbaei.drones.domain.medication.entity.Medication;

@Entity
@Table(name = "DRONES")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Drone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Length(max = 100)
	private String serial;

	@Max(500)
	private Double weight = 0d;

	@Enumerated(EnumType.STRING)
	private Model model = Model.LIGHT_WEIGHT;

	@Enumerated(EnumType.STRING)
	private Status status = Status.IDLE;

	@Max(100)
	private Integer battery = 100;

	@OneToMany
	@JoinColumn(name = "drone_id")
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

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
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
		LIGHT_WEIGHT, MIDDLE_WEIGHT, CRUISER_WEIGHT, HEAVY_WEIGHT,
	}

	public enum Status {
		IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING
	}
}
