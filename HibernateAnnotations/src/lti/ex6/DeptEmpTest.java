package lti.ex6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import lti.util.HibernateUtil;

public class DeptEmpTest {
	
	@Test
	public void testCase1() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.getTransaction();
		
		Department dept = new Department();
		dept.setDeptno(10);
		dept.setName("Admin");
		dept.setLocation("Andheri, Mumbai");
		
		tx.begin();
		session.save(dept);
		tx.commit();
	}
	
	@Test
	public void testCase2() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.getTransaction();
		
		tx.begin();
		Department dept = (Department) session.get(Department.class,10);
		
		Employee emp = new Employee();
		emp.setEmpno(1002);
		emp.setName("Wenda");
		emp.setSalary(3000.0);
		emp.setDept(dept);
				
		session.save(emp);
		tx.commit();
	}
	
}
