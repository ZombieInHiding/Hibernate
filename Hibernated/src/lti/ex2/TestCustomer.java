package lti.ex2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import lti.util.HibernateUtil;

public class TestCustomer {

	@Test
	public void testAddCustomer() {
		SessionFactory factory = HibernateUtil.getFactory();
		
		Session session = factory.getCurrentSession();
		Transaction txn = session.getTransaction();
		
		Customer c1 = new Customer();
		c1.setCustName("Diana");
		c1.setCredit(17000);
		
		try {
			txn.begin();
			session.save(c1);
			txn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
		} finally {
			factory.close();
		}
		
	}
	
	@Test
	public void testFetchCustomer() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Customer c = (Customer) session.get(Customer.class, 1);
		System.out.println(c.getCustName() + ": Rs. " +c.getCredit());
		factory.close();
	}
	
	@Test
	public void testAttachedUpdateCustomer() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction();
		
		Customer c =(Customer) session.get(Customer.class, 1);
		c.setCredit(99999.99);  // Update in attached scenario
		txn.commit();
		
		factory.close();
	}
	
	@Test
	public void testDetachedUpdateCustomer() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction();
		
		Customer c =(Customer) session.get(Customer.class, 1);
		txn.commit();
		
		session = factory.getCurrentSession();
	    txn = session.beginTransaction();
		
	    c.setCredit(110009.99); // Update in detached scenario
	    session.update(c);
		txn.commit();
		
		factory.close();
	}
	
	@Test
	public void testDeleteCustomer() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction();
		
		Customer c = (Customer) session.get(Customer.class, 1);
		session.delete(c);
		txn.commit();
		
		factory.close();
	}
	
}
