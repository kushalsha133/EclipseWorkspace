package com.kushal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kushal.hibernate.demo.entity.Course;
import com.kushal.hibernate.demo.entity.Instructor;
import com.kushal.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		//Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		try{
			//Create a Objects
			Instructor ins = new Instructor("kushal", "sharma", "dank@kush");
			InstructorDetail insDet = new InstructorDetail("kushal@youtube", "skipping");
			
			//associate the objects
			
			ins.setInstructorDetail(insDet);
			//start a transaction
			session.beginTransaction();
			//save the object
			System.out.println("object I'm saving : "+ins);
			session.save(ins);//this will also save insDet cause of Cascade.ALL
			System.out.println("Done");
			//commit
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
	}

}
