package com.kushal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kushal.hibernate.demo.entity.Course;
import com.kushal.hibernate.demo.entity.Instructor;
import com.kushal.hibernate.demo.entity.InstructorDetail;
import com.kushal.hibernate.demo.entity.Review;
import com.kushal.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentDemo {

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
			//create a course
			Course tempCourse = new Course("Pacman: How to Score a Mill");
			System.out.println("Saving the Course");
			//create the student
			Student tempStu1 = new Student("kush","shar","kush@shar");
			Student tempStu2 = new Student("ri","go","ri@go");
			tempCourse.addStudent(tempStu1);
			tempCourse.addStudent(tempStu2);
			
			//Saving the Student
			session.save(tempStu1);
			session.save(tempStu2);	
			System.out.println("Student saved"+tempCourse.getStudents().toString());
			session.save(tempCourse);
			//commit
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			session.close();
			factory.close();
		}
	}

}
