package com.zenbaei.drones.medication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Pattern;

import com.zenbaei.drones.drone.Drone;

@Entity
public class Medication {
	@Id
	@GeneratedValue
	private Long id;
	
	@Pattern(regexp = "^[a-zA-Z0-9_-]*$")
	private String name;
	
	private Double weight;
	
	@Pattern(regexp = "^[A-Z0-9_]*$")
	private String code;
	
	private String image;
	
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
	
	
}
