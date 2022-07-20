package com.kushal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kushal.hibernate.demo.entity.Instructor;
import com.kushal.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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
			//Create a Objects
			Instructor ins = new Instructor("dank3", "kush3", "dank@kush3");
			InstructorDetail insDet = new InstructorDetail("dankkush3", "hindukush3");
			
			//associate the objects
			
			ins.setInstructorDetail(insDet);
			//start a transaction
			session.beginTransaction();
			//save the object
			System.out.println("object I'm saving : "+ins);
			session.save(ins);//this will also save insDet cause of Cascade.ALL
			//commit
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}
