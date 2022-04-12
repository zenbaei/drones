package com.zenbaei.drones.domain.drone;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import javax.validation.ConstraintViolation;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import com.zenbaei.drones.test.BaseValidationTest;

public class DroneTest extends BaseValidationTest {

	
	@Test
	public void whenSerialEqual100_thenNoViolations() {
		Drone drn = new Drone();
		drn.setSerial(RandomStringUtils.randomAlphanumeric(100));
		Set<ConstraintViolation<Drone>> violations = validator.validate(drn);
		assertThat(violations.size()).isEqualTo(0);
	}
	
	@Test
	public void whenSerialExceeds100_thenViolationsShouldExist() {
		Drone drn = new Drone();
		drn.setSerial(RandomStringUtils.randomAlphanumeric(101));
		Set<ConstraintViolation<Drone>> violations = validator.validate(drn);
		assertThat(violations.size()).isGreaterThanOrEqualTo(1);
	}
}
