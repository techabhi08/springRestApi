package com.springrestapi.springrestapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person {
	
	@Id
	private long rollNo;
	private String name;
	private String email;
	private String phone;
	private String gender;
	
	public Person(long rollNo, String name, String email, String phone, String gender) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
	}
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRollNo() {
		return rollNo;
	}

	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", rollNo=" + rollNo + ", email=" + email + ", phone=" + phone + ", gender="
				+ gender + "]";
	}
	
	
}
