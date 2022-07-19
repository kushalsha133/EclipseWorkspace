package com.kushal.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kushal.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		//Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		try{
			//start a transaction
			session.beginTransaction();
			
			// Query Student
			List<Student> theStudents = session.createQuery("from Student").list();
			listStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='Sharma'").list();
			listStudents(theStudents);
			
			
			//commit
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

	private static void listStudents(List<Student> theStudents) {
		for(Student s : theStudents) {
			System.out.println(s);
		}
	}

}
