package com.kushal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kushal.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		//Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		try{
			//Create a Student Object
			Student ts = new Student("Kushal","Sharma","kush@kush.com");
			//start a transaction
			session.beginTransaction();
			//save the student
			session.save(ts);
			//commit
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}
