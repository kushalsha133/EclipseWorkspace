package com.kushal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kushal.hibernate.demo.entity.Instructor;
import com.kushal.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			System.out.println("ooooooooooooooooooooooooooooooo");
			int theId = 3;
			InstructorDetail tempInsDet = session.get(InstructorDetail.class, theId);
			System.out.println("object fetched : "+ tempInsDet);
			System.out.println("Instructor Detail : "+tempInsDet.getInstructor());
			//this here will delete the instructorDetailand the Instructor object.
			//say you dont want the instructor to be deleted in Bi directional mapping then 
			// you change the cascade type, and then delete but then INstructor object's instructorDetail 
			// reference should be assigned null otherwise itwill throw nullPointer Exception.
			tempInsDet.getInstructor().setInstructorDetail(null);
			session.delete(tempInsDet);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
