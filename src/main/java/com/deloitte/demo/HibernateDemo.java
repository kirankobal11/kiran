package com.deloitte.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			System.out.println("Add an new employee: ");
			System.out.println("Enter name:");
			System.out.println("Enter salary: ");
			
			Employee newEmployee = new Employee("Soni", 85.25);
			
			session.beginTransaction();
			
			session.save(newEmployee);
			

			session.getTransaction().commit();

			List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
			
		
			for (Employee emp : employees) {
				System.out.println(emp);
			}

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			factory.close();
		}
	}
}