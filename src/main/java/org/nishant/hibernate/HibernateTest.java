package org.nishant.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.codejava.hibernate.dto.UserDetails;

public class HibernateTest {
	public static void main(String[] args) throws InterruptedException{
		
		//Normally we'd use DAO to create a data layer and the data layer will use hibernate to save this.
		UserDetails user = new UserDetails();
		user.setUserName("firstUser");
		user.setAddress("First User's address");
		user.setJoinedDate(new Date());
		user.setDescription("First user's description");
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("secondUser");
		user2.setAddress("address of user 2");
		user2.setDescription("desc for user 2");
		user.setJoinedDate(new Date());
		
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit(); //db commit
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		/**We ask for the class equivalent of the table that we want. UserDetails represent the table UserDetails
		 * 1 is the value of the primary key. We don't have to specify what column is the primary key,
		 * since we have already annotated userId as ID, and thus hibernate knows which column to lookup
		 */
		user = session.get(UserDetails.class, 1); 
		System.out.println(user.getUserName());
		
	}
}
