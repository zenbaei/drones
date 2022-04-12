package com.zenbaei.drones.domain.drone;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import com.zenbaei.drones.domain.medication.Medication;
import com.zenbaei.drones.domain.medication.MedicationService;

@SpringBootTest
public class DroneServiceIT {

	@Autowired
	MedicationService medicationService;

	@Autowired
	DroneService droneService;

	@Test
	@Transactional
	public void givenDbHasData_whenUpdatingDroneWithMedications_thenItShouldUpdateMedicatoinsFk() {
		Drone drone = droneService.findById(1l).get();
		List<Medication> medications = medicationService.findAll();
		drone.setMedications(medications.subList(0, 2));

		droneService.update(1, drone);
		Drone updDrn = droneService.findById(1l).get();

		assertThat(updDrn.getMedications().size()).isEqualTo(2);
	}

	@Test
	public void givenDbHasData_whenUpdatingDroneWithMedicationsOverWeighted_thenItShouldThrowException() {
		Drone drone = droneService.findById(1l).get();
		List<Medication> medications = medicationService.findAll();
		medications.forEach((m) -> m.setWeight(300d));

		drone.setMedications(medications.subList(0, 2));

		assertThrows(TransactionSystemException.class, () -> droneService.update(1, drone));
	}
}
