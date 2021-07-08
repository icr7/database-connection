package com.icr7.jdbc.connectivity;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.icr7.entity.UserEntity;

public class Check {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(UserEntity.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			UserEntity temp = new UserEntity("ishwar", 
					"singh","9458595189" ,
					"ishwarchaiser@gmail.com","icr7");

			session.save(temp);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
}
}