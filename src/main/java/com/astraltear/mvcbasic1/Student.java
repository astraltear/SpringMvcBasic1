package com.astraltear.mvcbasic1;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


public class Student {
	private String studentName;
	
	@Size(min=2, max=30)
	private String studentHobby;
	private Long studentMobile;
	private Date studentRegDate;
	
	private ArrayList<String> studentSkills;
	private Address studentAddress;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentHobby() {
		return studentHobby;
	}
	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}
	public Long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}
	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	public Date getStudentRegDate() {
		return studentRegDate;
	}
	public void setStudentRegDate(Date studentRegDate) {
		this.studentRegDate = studentRegDate;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentHobby=" + studentHobby + ", studentMobile="
				+ studentMobile + ", studentRegDate=" + studentRegDate + ", studentSkills=" + studentSkills
				+ ", studentAddress=" + studentAddress + "]";
	}
	
	
	
}
