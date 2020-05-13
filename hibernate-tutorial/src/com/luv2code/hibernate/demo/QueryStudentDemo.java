package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;
import java.util.List;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Starting transaction...");
			session.beginTransaction();
			
//			query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			displayStudents(theStudents);
			
//			query students lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Chan'").getResultList();
			displayStudents(theStudents);
			
			
			System.out.println("Committing transaction...");
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student s : theStudents) {
			System.out.println(s);
		}
	}

}
