package com.kushal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kushal.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		try{
			//start a transaction
			session.beginTransaction();
			int studentId = 1;
			System.out.println("getting student id with"+studentId);
			Student st = session.get(Student.class, studentId);
			
			//updating student
			System.out.println("updating student object");
			st.setFirstName("Scooby");
			//or we can use queries also
			/* session.createQuery("update Student set email='abc@xwq' where firstName='').executeUpdate();*/
			//commit the transaction
			session.getTransaction().commit();
			System.out.println(st.toString());
			
		}finally {
			factory.close();
		}
	}

}
