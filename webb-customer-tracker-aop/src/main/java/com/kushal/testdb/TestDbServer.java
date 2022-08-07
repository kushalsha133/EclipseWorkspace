package com.kushal.testdb;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class TestDbServer
 */
//@WebServlet(name = "TestDbServlet", urlPatterns = { "/TestDbServlet" })
@WebServlet("/TestDbServer")
public class TestDbServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//setup connection variables
		String user = "springstudent";
		String pass = "springstudent";
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3307/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		//get connection to database
		try {
			PrintWriter out = response.getWriter();
			System.out.println("VVVVVVVVVVVVVVVVVVVVVXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			out.println("Connection to databse : "+jdbcUrl);
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("Connection Successful");
			myConn.close();
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
	}

}
