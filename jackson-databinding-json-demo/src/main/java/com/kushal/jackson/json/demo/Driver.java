package com.kushal.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {
	public static void main(String[] args) {
		try {
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			//read JSON file anmd map/convert to pojo
			Student theStudent = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			
			//print firstName and lastName
			System.out.println("FirstName: "+theStudent.getFirstName());
			System.out.println("LastName: "+theStudent.getLastName());
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
