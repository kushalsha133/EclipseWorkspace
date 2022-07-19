package com.kushal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kushal.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student ts = new Student("daffy","duck","daffy@kush.com");
			//start a transaction
			session.beginTransaction();
			//save the student
			session.save(ts);
			//commit
			session.getTransaction().commit();
			
			System.out.println("Saved Student. Generated ID :"+ ts.getId());
			//get a new session
			session = factory.getCurrentSession();
			//retreive student based on id
			session.beginTransaction();
			
			System.out.println("getting student with id: "+ ts.getId());
			Student st = session.get(Student.class, ts.getId());
			
			session.getTransaction().commit();
			System.out.println(st.toString());
			
		}finally {
			factory.close();
		}
	}

}
