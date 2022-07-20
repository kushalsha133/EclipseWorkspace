package com.kushal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kushal.hibernate.demo.entity.Course;
import com.kushal.hibernate.demo.entity.Instructor;
import com.kushal.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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

			//get the instructor from db
			//create some courses
			//add courses to db
			//save the courses
			int theId = 1;
			Instructor ins = session.get(Instructor.class, theId);
			
			Course tempCourse1 = new Course("pottery101");
			Course tempCourse2 = new Course("japanese101");
			
			ins.add(tempCourse1);
			ins.add(tempCourse2);
			
			//save the object
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			//commit
			
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			session.close();
			factory.close();
		}
	}

}
