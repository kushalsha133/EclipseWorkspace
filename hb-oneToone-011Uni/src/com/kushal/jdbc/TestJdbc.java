package com.kushal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//jdbc:mysql://127.0.0.1:3307/?user=hbstudent
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3307/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		try{
			System.out.println("Connecting to Database: "+jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection Successful");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
