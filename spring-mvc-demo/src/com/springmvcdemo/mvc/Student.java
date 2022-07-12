package com.springmvcdemo.mvc;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {
	
	
	private String firstName;
	private String lastName;
	private String country;
	private String favLang;
	private String[] operatingSystems; 
	//private LinkedHashMap<String, String> countryOptions;

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public String getFavLang() {
		return favLang;
	}

	public void setFavLang(String favLang) {
		this.favLang = favLang;
	}

	public Student() {
//		countryOptions = new LinkedHashMap<String, String>();
//		countryOptions.put("", "");
//		countryOptions.put("BR", "Brazil");
//		countryOptions.put("FR", "France");
//		countryOptions.put("IN", "India");
//		countryOptions.put("DE", "Germany");
	}
	
//	public LinkedHashMap<String, String> getCountryOptions() {
//		return countryOptions;
//	}
//
//	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
//		this.countryOptions = countryOptions;
//	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	
}
