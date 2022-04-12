package com.zenbaei.drones.common.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

public class ValidationUtils {
	
	/**
	 * Checks standard validation violations.
	 * @param <T>
	 * @param violations
	 * @throws ConstraintViolationException if violations exist
	 */
	public static <T> void check(Set<ConstraintViolation<T>> violations) {
		if (!violations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (ConstraintViolation<T> constraintViolation : violations) {
				sb.append(constraintViolation.getPropertyPath())
					.append(": ")
				    .append(constraintViolation.getMessage());
			}
			throw new ConstraintViolationException(sb.toString(), violations);
		}
	}

}
