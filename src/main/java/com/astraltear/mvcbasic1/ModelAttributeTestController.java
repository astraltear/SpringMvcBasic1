package com.astraltear.mvcbasic1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelAttributeTestController {
	private static Logger logger = LoggerFactory.getLogger(ModelAttributeTestController.class);
	
	@ModelAttribute(value="paramModelAttr")
	public Student getModelAttr() {
		logger.info("getModelAttr  CALL!!:");
		Student student = new Student();
		student.setStudentName("TWICE");
		student.setStudentHobby("WOOAH~~~~~~~");
		student.setStudentMobile(new Long(55555));
		return student;
	}
	
//  http://localhost:8080/mvcbasic1/paramModelAttr
	@RequestMapping("/paramModelAttr")
	public String paramModelAttr(@ModelAttribute(value="paramModelAttr") Student student) {
		logger.info("paramModelAttr getDTO"+student.toString());
		return "paramModelAttr";
	}

//  http://localhost:8080/mvcbasic1/paramModelAttr2
	@RequestMapping("/paramModelAttr2")
	public String paramModelAttr2(@ModelAttribute("paramModelAttr") Student student) {
		logger.info("paramModelAttr getDTO"+student.toString());
		
		student.setStudentName("CHANGE NAME");
		student.setStudentHobby("CHANGE HOBBY");
		student.setStudentMobile(new Long(9999));
		
		return "paramModelAttr";
	}
}
