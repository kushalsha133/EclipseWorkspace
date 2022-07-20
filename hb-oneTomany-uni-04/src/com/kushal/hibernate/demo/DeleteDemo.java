package com.kushal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kushal.hibernate.demo.entity.Instructor;
import com.kushal.hibernate.demo.entity.InstructorDetail;
import com.kushal.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		//Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		try{
			//start a transaction
			session.beginTransaction();
			
			int theId = 1;
			Instructor tempIns = session.get(Instructor.class, theId);
			System.out.println("object fetched : "+ tempIns);
			
			//delete the object
			if(tempIns != null) {
				System.out.println("DeletingObject with Id : "+theId);
				session.delete(tempIns);
			}
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}
