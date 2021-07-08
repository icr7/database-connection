package com.icr7.UsersDao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.icr7.entity.UserEntity;

public class CrudDao {
	public CrudDao() {
		// no args constructor
	}

	// function for saving data
	public void saveUserData(UserEntity entity) {
		System.out.println("checking incomming data:");
		System.out.println(entity.getFirstName());
		System.out.println(entity.getLastName());
		System.out.println(entity.getMobileNo());
		System.out.println(entity.getEmail());
		System.out.println(entity.getPassWord());
		

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserEntity.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			UserEntity temp = new UserEntity(entity.getFirstName(), entity.getLastName(), entity.getMobileNo(),
					entity.getEmail(), entity.getPassWord());

			session.save(temp);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

	// function for getting single user data
	public UserEntity getUserData(String i) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserEntity.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		UserEntity userEntity;
		try {
			session.beginTransaction();

			// query for user with email given by function
			Query query = session.createQuery("from UserEntity u where u.email=:e ");
			query.setParameter("e", i);

			userEntity = (UserEntity) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		} finally {
			factory.close();
		}

		return userEntity;
	}

	public List<UserEntity> getUserData() {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserEntity.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		List<UserEntity> userEntity;
		try {
			session.beginTransaction();

			{// query for user with email given by function
				Query query = session.createQuery("from UserEntity ");

				userEntity = query.getResultList();
			}
		} catch (NoResultException nre) {
			return null;
		}

		finally {
			factory.close();
		}

		return userEntity;
	}

}
