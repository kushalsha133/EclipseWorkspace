package com.kushal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kushal.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
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
			Student ts = new Student("Kushal1","Sharma1","kush1@kush.com");
			Student ts2 = new Student("Kushal2","Sharma2","kush2@kush.com");
			Student ts3 = new Student("Kushal3","Sharma3","kush3@kush.com");
			//start a transaction
			session.beginTransaction();
			//save the student
			session.save(ts);
			session.save(ts2);
			session.save(ts3);
			//commit
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}
}
