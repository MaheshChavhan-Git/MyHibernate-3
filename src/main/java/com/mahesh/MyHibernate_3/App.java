package com.mahesh.MyHibernate_3;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Session session1 = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction1 = session1.beginTransaction();
//		Employee employee = new Employee();
//		employee.setName("Pratik");
//		employee.setDepartment("MKCL");
//		session1.save(employee);
//		transaction1.commit();
//		session1.close();
		Employee e1 = session1.load(Employee.class, 1);
		System.out.println(e1);
		
		Session session2 = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction2 = session2.beginTransaction();
		Employee e2 = session2.load(Employee.class, 1);
		System.out.println(e2);

	}
}
