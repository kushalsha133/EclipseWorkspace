package com.kushal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.kushal.hibernate.demo.entity.Course;
import com.kushal.hibernate.demo.entity.Instructor;
import com.kushal.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			int theId = 1;
			
			//Lets use HQL
			Query<Instructor> query = session.createQuery("Select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId", Instructor.class);
			//:theInstructorId is a parameter
			query.setParameter("theInstructorId", theId);
			
			Instructor ins = query.getSingleResult();
			System.out.println("Kush: Instructor : "+ins);
			
			
			//commit
			session.getTransaction().commit();
			System.out.println("KushDone");
		}finally {
			session.close();
			factory.close();
		}
	}

}
