package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object...");
			Student s = new Student("Daffy", "Duck", "dduck@yahoo.com");
			
			System.out.println("Starting transaction...");
			session.beginTransaction();
			
			System.out.println("Saving student object...");
			System.out.println(s);
			session.save(s);
			
			System.out.println("Committing transaction...");
			session.getTransaction().commit();
			
//			READ OBJECT CODE
//			find student id
			System.out.println("Saved student. Generated id: " + s.getId());

//			get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			retrieve student based on the id
			System.out.println("\nGetting student with id: " + s.getId()); 
			Student myStudent = session.get(Student.class, 5);
			System.out.println("Get complete: " + myStudent);
			
//			commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			factory.close();
		}

	}

}
