package com.astraltear.support;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.astraltear.mvcbasic1.FormValidDTO;

public class FormValidDTOTest {

	private static Validator validator;
	
	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void userIdIsNull() {
		FormValidDTO dto = new FormValidDTO(null, "password", "name", "");
		Set<ConstraintViolation<FormValidDTO>> constraintViolations = validator.validate(dto);
		
		assertEquals(1,constraintViolations.size());
//		assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
		System.out.println(constraintViolations.iterator().next().getMessage());
	}
	
	@Test
	public void userIdLength() {
		FormValidDTO dto = new FormValidDTO("us", "password", "name", "");
		Set<ConstraintViolation<FormValidDTO>> constraintViolations = validator.validate(dto);
		
		assertEquals(1,constraintViolations.size());
		System.out.println(constraintViolations.iterator().next().getMessage());
		
	}
	
	@Test
	public void emailCheck() {
		FormValidDTO dto = new FormValidDTO("userid", "password", "name", "email");
		Set<ConstraintViolation<FormValidDTO>> constraintViolations = validator.validate(dto);
		
		assertEquals(1,constraintViolations.size());
		System.out.println(constraintViolations.iterator().next().getMessage());
	}
	
	@Test
	public void invalidDTO() {
		FormValidDTO dto = new FormValidDTO("us", "password", "name", "email");
		Set<ConstraintViolation<FormValidDTO>> constraintViolations = validator.validate(dto);
		
		assertEquals(2,constraintViolations.size());
		
		Iterator<ConstraintViolation<FormValidDTO>> violations = constraintViolations.iterator();
		while (violations.hasNext()) {
			ConstraintViolation<FormValidDTO> each = violations.next();
			System.out.println(each.getPropertyPath()+":"+each.getMessage());
		}
	}
}
