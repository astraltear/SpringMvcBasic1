package com.astraltear.mvcbasic1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class FormValidDTO {

	@NotNull
	@Size(min=4, max=12)
	private String userId;
	
	@NotNull
	@Size(min=4, max=12)
	private String password;
	
	@NotNull
	@Size(min=4, max=10)
	private String name;
	
	@Email
	private String email;
	
	public FormValidDTO(String userId, String password, String name, String email) {
		super();
		this.name = name;
		this.password = password;
		this.userId = userId;
		this.email = email;
	}
}
