package org.nishant.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.codejava.hibernate.dto.UserDetails;

public class HibernateTest {
	public static void main(String[] args){
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("firstUser");
		//Normally we'd use DAO to create a data layer and the data layer will use hibernate to save this.
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit(); //db commit
	}
}
