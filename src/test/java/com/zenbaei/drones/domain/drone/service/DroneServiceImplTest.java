package com.zenbaei.drones.domain.drone.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.zenbaei.drones.domain.medication.entity.Medication;

public class DroneServiceImplTest {

	@Test
	public void testingMedicationsWeightSum() {
		Medication m1 = new Medication();
		Medication m2 = new Medication();
		
		m1.setWeight(100d);
		m2.setWeight(20d);
		
		double val = DroneServiceImpl.sumWeight(Arrays.asList(m1, m2));
		
		assertThat(val).isEqualTo(120d);
	}
}
