package com.kushal.jackson.json.demo;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//say at some point some extra fields are added in the Json file, our program
//won't break it will just ignore those properties due to this annotation
@JsonIgnoreProperties(ignoreUnknown=true)
public class Student2 {
	private int id;
	private String firstName;
	private String lastName;
	private boolean active;
	private Address address;
	private String[] languages;
	
	@Override
	public String toString() {
		return "Student2 [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", active=" + active
				+ ", address=" + address + ", languages=" + Arrays.toString(languages) + "]";
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Student2() {}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
