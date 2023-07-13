package com.springrestapi.springrestapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Person {
	
	@Id
	@NotNull(message = "Roll Number should not be empty")
	private long rollNo;
	
	@NotEmpty
	@Size(min = 3, message = "Name should not be empty and must be atleast 3 characters long")
	private String name;
	
	@Email(message = "Email address is not valid!")
	private String email;
	
	@NotNull
	@Pattern(regexp = "^\\d{10}$", message = "Phone number should be 10 digits long.")
	private String phone;
	
	@NotEmpty
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
