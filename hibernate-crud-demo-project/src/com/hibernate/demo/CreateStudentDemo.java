package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			Student student = new Student("Taher", "Ali", "tali20@gmail.com"); // student is in transient state
			session.beginTransaction();
			int i = (Integer) session.save(student); // student is in persistent state
			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}
	}

}
