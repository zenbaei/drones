package com.zenbaei.drones.domain.medication.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import javax.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import com.zenbaei.drones.test.BaseValidationTest;

public class MedicationTest extends BaseValidationTest {

	
	@Test
	public void whenSerialHaveNoSigns_thenNoViolations() {
		Medication mdc = new Medication();
		mdc.setName("-_9-nN");
		Set<ConstraintViolation<Medication>> violations = validator.validate(mdc);
		assertThat(violations.size()).isEqualTo(0);
	}
	
	@Test
	public void whenSerialHaveSigns_thenViolationsShouldExist() {
		Medication mdc = new Medication();
		mdc.setName("-_9$nN");
		Set<ConstraintViolation<Medication>> violations = validator.validate(mdc);
		assertThat(violations.size()).isGreaterThanOrEqualTo(1);
	}
	
	@Test
	public void whenCodeHaveNoLowerLetter_thenNoViolations() {
		Medication mdc = new Medication();
		mdc.setCode("_9NFF8");
		Set<ConstraintViolation<Medication>> violations = validator.validate(mdc);
		assertThat(violations.size()).isEqualTo(0);
	}
	
	@Test
	public void whenCodeHaveLowerLetter_thenViolationsShouldExist() {
		Medication mdc = new Medication();
		mdc.setCode("_9NFFn8");
		Set<ConstraintViolation<Medication>> violations = validator.validate(mdc);
		assertThat(violations.size()).isGreaterThanOrEqualTo(1);
	}
}
