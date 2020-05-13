package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object...");
			Student s = new Student("Billie", "Eilish", "beilsich@google.com");
			
			System.out.println("Starting transaction...");
			session.beginTransaction();
			
			System.out.println("Saving student object...");
			session.save(s);
			
			System.out.println("Committing transaction...");
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			factory.close();
		}

	}

}
