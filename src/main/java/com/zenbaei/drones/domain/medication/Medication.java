package com.zenbaei.drones.domain.medication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zenbaei.drones.domain.drone.Drone;

@Entity
@Table(name = "MEDICATIONS")
public class Medication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Pattern(regexp = "^[a-zA-Z0-9_-]*$")
	private String name;
	
	@NotNull
	private Double weight;
	
	@Pattern(regexp = "^[A-Z0-9_]*$")
	private String code;
	
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "drone_id")
	private Drone drone;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Drone getDrone() {
		return drone;
	}	
	public void setDrone(Drone drone) {
		this.drone = drone;
	}
	
}
