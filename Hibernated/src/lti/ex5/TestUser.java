package lti.ex5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import lti.util.HibernateUtil;

public class TestUser {
	
	@Test
	public void testCase1() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.getTransaction();
		
		// User Object
		User u = new User();
		u.setFirstname("Polo");
		u.setLastname("Mint");
		u.setUsername("polo");
		u.setPassword("polo123");
		
		// Address object
		Address address = new Address();
		address.setCity("Mumbai");
		address.setStreet("Powai");
		address.setZipcode("400083");
		
		u.setAddress(address);
		address.setUser(u);
		
		// save is not valid without active transaction. 
		//so it's a must to write .begin statement
		txn.begin();  		
		session.save(u);
		txn.commit();
	}

}
