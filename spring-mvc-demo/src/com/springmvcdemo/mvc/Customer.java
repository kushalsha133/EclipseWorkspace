package com.springmvcdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.springmvcdemo.mvc.validation.CourseCode;

public class Customer {
	
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@NotNull(message="is required")
	@Size(min=1, message="is required") //agar message nahi doge to default message show hoyega
	private String lastName;
	//sirf size 1 se agar user space bhi enter ksrega to validation fail nahi hogi
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	//to make an int filed NotNull, change it to reference datatype Integer
	@NotNull(message="Required")
	@Min(value=0, message="must be greater than or equal to zero")
	@Max(value=10, message="must be greater than or equal to 10")
	private Integer freePasses;
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 Char/digits")
	private String postalCode;
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@CourseCode   //idhar chalega default values which is LUV
	//@CourseCode(value="TOPS", message = "Must Start with TOPS") // idhar chalega custom
	private String courseCode;
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
    
	
}
