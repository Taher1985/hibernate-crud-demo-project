package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			Student student = new Student("Anil", "Pal", "apal20@gmail.com"); // student is in transient state
			session.beginTransaction();
			System.out.println("Saving the student...");
			int i = (Integer) session.save(student); // student is in persistent state
			session.getTransaction().commit();
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Student studentPK = session.get(Student.class, student.getId());
			System.out.println(studentPK);
			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}
	}

}
