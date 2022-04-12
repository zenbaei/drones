package com.zenbaei.drones.domain.drone.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import com.zenbaei.drones.domain.drone.entity.Drone;
import com.zenbaei.drones.domain.medication.entity.Medication;
import com.zenbaei.drones.domain.medication.service.MedicationServiceImpl;

@SpringBootTest
public class DroneServiceImplIT {

	@Autowired
	MedicationServiceImpl medicationService;

	@Autowired
	DroneServiceImpl droneService;

	@Test
	public void givenDbHasData_whenUpdatingDroneWithMedications_thenItShouldUpdateMedicationsFk() {
		Drone drone = droneService.getByIdEagerly(1);
		List<Medication> medications = medicationService.findAll();
		drone.setMedications(medications.subList(0, 2));
		drone.setSerial("ay");
		droneService.update(1, drone);

		Drone updDrn = droneService.getByIdEagerly(1);

		assertThat(updDrn.getMedications().size()).isEqualTo(2);
	}

	@Test
	public void givenDbHasData_whenUpdatingDroneWithMedicationsOverWeighted_thenItShouldThrowException() {
		Drone drone = droneService.getByIdEagerly(1);
		List<Medication> medications = medicationService.findAll();
		medications.forEach((m) -> m.setWeight(300d));

		drone.setMedications(medications.subList(0, 2));

		assertThrows(TransactionSystemException.class, () -> droneService.update(1, drone));
	}
}
