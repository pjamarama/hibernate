package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 7;
			
//			READ OBJECT CODE

////			get a new session and start transaction
//			session = factory.getCurrentSession();
//			session.beginTransaction();
			
////			retrieve student based on the id
//			System.out.println("\nGetting student with id: " + studentId); 
//			Student myStudent = session.get(Student.class, studentId);
//			System.out.println("Updating student");
//			myStudent.setFirstName("Scooby");
//			
////			commit the transaction
//			session.getTransaction().commit();
//			System.out.println("Done");
			
//			BULK UPDATE change Duck's email
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='ducks@hotmail.com' where lastName = 'Duck'").executeUpdate();
			session.getTransaction().commit();
			
			
		} finally {
			factory.close();
		}

	}

}
