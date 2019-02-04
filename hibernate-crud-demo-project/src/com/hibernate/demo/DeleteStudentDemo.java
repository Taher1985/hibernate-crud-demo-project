package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Student student = session.get(Student.class, 2);
			session.delete(student);
			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}
	}

}
