package com.kushal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kushal.hibernate.demo.entity.Course;
import com.kushal.hibernate.demo.entity.Instructor;
import com.kushal.hibernate.demo.entity.InstructorDetail;
import com.kushal.hibernate.demo.entity.Review;
import com.kushal.hibernate.demo.entity.Student;

public class DeleteKushStudentDemo {

	public static void main(String[] args) {
		//Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		try{
			//start a transaction
			session.beginTransaction();
			//get student Kush
			int theId=1;
			Student tempStu = session.get(Student.class, theId);
			System.out.println("Loaded Student: "+tempStu);
			System.out.println("Enrolled Courses: "+tempStu.getCourses().toString());
			
			//delete student
			System.out.println("Deleting Student");
			session.delete(tempStu);
			
			//commit
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			session.close();
			factory.close();
		}
	}

}
