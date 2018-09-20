package lti.ex1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import lti.util.HibernateUtil;

public class TestProduct {

	@Test
	public void testAddProduct() {
		SessionFactory factory = HibernateUtil.getFactory();

		Session session = factory.getCurrentSession();
		Transaction txn = session.getTransaction();

		Product p1 = new Product();
		p1.setName("Redmi");
		p1.setPrice(25000);

		try {
			txn.begin();
			session.save(p1);
			txn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
		} finally {
			factory.close();
		}

	}

	@Test
	public void testFetchProduct() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Product p = (Product) session.get(Product.class, 21);
		System.out.println(p.getName() + ": Rs. " + p.getPrice());
		factory.close();
	}

	@Test
	public void testAttachedUpdateProduct() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction();

		Product p = (Product) session.get(Product.class, 21);
		p.setPrice(119999.99); // Update in attached scenario
		txn.commit();

		factory.close();
	}

	@Test
	public void testDetachedUpdateProduct() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction();

		Product p = (Product) session.get(Product.class, 21);
		txn.commit();

		session = factory.getCurrentSession();
		txn = session.beginTransaction();

		p.setPrice(110009.99); // Update in detached scenario
		session.update(p);
		txn.commit();

		factory.close();
	}

	@Test
	public void testDeleteProduct() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction();

		Product p = (Product) session.get(Product.class, 21);
		session.delete(p);
		txn.commit();

		factory.close();
	}

	@Test
	public void testFetchProducts() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		//HQL uses entity name and attribute name
		
		// Query hql = session.createQuery("from Product"); //fetch all records
		/*
		 * Query hql = session.createQuery("from Product order by price"); //order by clause 
		 * List<Product> products = hql.list(); 
		 * for (Product p : products)
		 * System.out.println(p.getName() + ": " + p.getPrice());
		 */

		/*
		 * //particular columns 
		 * Query hql = session.createQuery("select name, price from Product"); 
		 * List<Object[]> products = hql.list(); 
		 * for (Object[] obj : products)
		 * System.out.println(obj[0] + ": " + obj[1]);
		 */

		/*
		 * Query hql = session.createQuery("from Product where price between 20000 and 800000");
		 * List<Product> products = hql.list(); 
		 * for (Product p : products)
		 * System.out.println(p.getName() + ": " + p.getPrice());
		 */

		/*//using NamedQuery
		 Query hql = session.getNamedQuery("getAll");
		List<Product> products = hql.list();
		for (Product p : products)
			System.out.println(p.getName() + ": " + p.getPrice());*/

		/*//Single record
		Query hql = session.createQuery("from Product where code = 3");
		Product p = (Product)hql.uniqueResult();
		System.out.println(p.getName() + ": " + p.getPrice());*/
		
		//Placeholder
		Query hql = session.createQuery("from Product where code = :cd");
		hql.setInteger("cd", 3);
		Product p = (Product)hql.uniqueResult();
		System.out.println(p.getName() + ": " + p.getPrice());
		
		factory.close();
	}

	@Test
	public void testNativeQueries() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		//SQL uses column name and table name
		
		/*SQLQuery sql = session.createSQLQuery("select p_name, price from product");
		List<Object[]> products = sql.list(); 
		for (Object[] obj : products)
		   System.out.println(obj[0] + ": " + obj[1]);*/
		
		/*SQLQuery sql = session.createSQLQuery("select p_code, p_name, price from product");
		sql.addEntity(Product.class);
		List<Product> products = sql.list();
		for (Product p : products)
			System.out.println(p.getName() + ": " + p.getPrice());*/
		
		SQLQuery sql = (SQLQuery) session.getNamedQuery("code1"); 
		sql.addEntity(Product.class);
		Product p = (Product) sql.uniqueResult();
		System.out.println(p.getName() + ": " + p.getPrice());
		
		factory.close();

	}
	
	@Test
	public void testCriteria() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		/*//fires select statement
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> products = criteria.list();
		for (Product p : products)
			System.out.println(p.getName() + ": " + p.getPrice());*/
		
		//fires select statement with where clause
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.between("price", 10000.0, 100000.0)); //between
		criteria.add(Restrictions.ilike("name", "%d%")); //like
		criteria.addOrder(Order.asc("price"));
		
		List<Product> products = criteria.list();
		for (Product p : products)
			System.out.println(p.getName() + ": " + p.getPrice());
		
		factory.close();
	}
	
	@Test
	public void testCaching() {
		SessionFactory factory = HibernateUtil.getFactory();
		//L2 Cache - factory level cache explicit EHCache
		Session session1 = factory.getCurrentSession();
		session1.beginTransaction();
		//L1 Cache - Session level cache implicit
		Product p1 = (Product) session1.get(Product.class, 1);
		System.out.println(p1.getName());
		
		Product p2 = (Product) session1.get(Product.class, 1);
		System.out.println(p2.getName());
		session1.close();
		
		Session session2 = factory.getCurrentSession();
		session2.beginTransaction();
		Product p3 = (Product) session2.get(Product.class, 1);
		System.out.println(p3.getName());
		
		session2.close();
		factory.close();
	}
}
