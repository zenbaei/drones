package com.zenbaei.drones.domain.drone.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.zenbaei.drones.domain.drone.entity.Drone;
import com.zenbaei.drones.domain.drone.service.DroneService;
import com.zenbaei.drones.domain.medication.entity.Medication;
import com.zenbaei.drones.domain.medication.service.MedicationService;

@SpringBootTest
@AutoConfigureWebMvc
@TestInstance(Lifecycle.PER_CLASS)
public class DroneRestControllerIT {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	MockMvc mvc;
	
	@Autowired
	DroneService droneService;
	
	@Autowired
	MedicationService medicationService;
	
	@BeforeAll
	  public void setUp() {
	    mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	  }
	
	@Test
	public void givenDataExistsInDb_testLazyLodingMedications() throws Exception {
		Drone drone = droneService.getByIdEagerly(1l);
		List<Medication> medications = medicationService.findAll();
		
		drone.setMedications(medications.subList(0, 1));
		
		droneService.update(1, drone);
		
		mvc.perform(get("/api/drones/1")).andExpect(status().isOk());
	}
}
