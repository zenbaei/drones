package com.zenbaei.drones;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseValidationTest {

	protected static ValidatorFactory validatorFactory;
	protected static Validator validator;
	
	@BeforeAll
	public static void createValidator() {
	    validatorFactory = Validation.buildDefaultValidatorFactory();
	    validator = validatorFactory.getValidator();
	}

	@AfterAll
	public static void close() {
	    validatorFactory.close();
	}
}
