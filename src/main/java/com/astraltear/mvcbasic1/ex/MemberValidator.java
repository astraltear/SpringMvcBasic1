package com.astraltear.mvcbasic1.ex;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		MemberDTO memberDTO = (MemberDTO) obj;
		
		String name = memberDTO.getName();
		String id = memberDTO.getId();
		
		if (name == null || name.trim().isEmpty()) {
			errors.rejectValue("nameError", "Member name is null or empty");
		}
		
		if (id == null || id.trim().isEmpty()) {
			errors.rejectValue("idError", "Member id is null or empty");
		}
	}
}
