package lti.ex3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import lti.util.HibernateUtil;

public class TestBook {

	@Test
	public void testSaveBook() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();

		Transaction txn = session.getTransaction();
		
		session.beginTransaction();
		
		Book alc = new Book(34524, "The Alchemist", "Paulo Coehlo", 350);
		session.save(alc);
		txn.commit();
	}

	@Test
	public void testGetBook() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		Book bk = (Book) session.get(Book.class, 1);
		System.out.println(bk);
	}
	
	@Test
	public void testGetByIsbn() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		Book bk = (Book) session.bySimpleNaturalId(Book.class).load(34524);
		System.out.println(bk);
	}

}
