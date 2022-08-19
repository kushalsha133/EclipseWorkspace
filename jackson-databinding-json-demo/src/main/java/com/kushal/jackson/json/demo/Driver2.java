package com.kushal.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver2 {
	public static void main(String[] args) {
		try {
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			//read JSON file anmd map/convert to pojo
			Student2 theStudent = mapper.readValue(new File("data/sample-full.json"), Student2.class);
			
			//print firstName and lastName
			System.out.println(theStudent);
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
