package com.kushal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kushal.hibernate.demo.entity.Course;
import com.kushal.hibernate.demo.entity.Instructor;
import com.kushal.hibernate.demo.entity.InstructorDetail;
import com.kushal.hibernate.demo.entity.Review;

public class DeleteCoursesAndReviewsDemo {

	public static void main(String[] args) {
		//Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		try{
			//start a transaction
			session.beginTransaction();
			//get the course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			//print the course 
			System.out.println("Deleting The Course:");
			System.out.println("Course : "+tempCourse);
			//print the Course Reviews
			System.out.println("Course Reviews:"+tempCourse.getReviews());
			//Delete the COurse
			session.delete(tempCourse);
			//commit
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			session.close();
			factory.close();
		}
	}

}
