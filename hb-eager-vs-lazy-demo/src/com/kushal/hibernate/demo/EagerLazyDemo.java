package com.kushal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kushal.hibernate.demo.entity.Course;
import com.kushal.hibernate.demo.entity.Instructor;
import com.kushal.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
			//start a transaction
			session.beginTransaction();
			
			int theId = 2;
			Instructor ins = session.get(Instructor.class, theId);
			System.out.println("Kush: Instructor : "+ins);
			
			//Get the courses of the instructor
			System.out.println("Kush: Courses : "+ins.getCourses().toString());
			
			//commit
			session.getTransaction().commit();
			System.out.println("KushDone");
		}finally {
			session.close();
			factory.close();
		}
	}

}
