package com.cg.user.annotation.single;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cg.util.annotation.HibernateUtil;

public class EmployeeApp {

	public static void main(String[] args) {

		 System.out.println("Hibernate Single (Annotation)");
			Session session = HibernateUtil.getSessionFactory().openSession();

			 Transaction tx= session.beginTransaction();
			 
				/*
				 * Employee employee=new Employee(); employee.setFirstName("Ramesh");
				 * employee.setLastName("Varma"); employee.setPancard("ABC12345");
				 * employee.setEmailId("ramesh.varma@gmail.com"); employee.setSal(20000);
				 * session.save(employee); tx.commit();
				 */
			 System.out.println("Using Criteria");
			 Criteria criteria=session.createCriteria(Employee.class);
			 List<Employee> employeeList= criteria.list();
			 employeeList.forEach(emp->{
				 
				 System.out.println(emp.getId()+" "+emp.getFirstName());
			 });
			 
			 
			 
			 
			 
			 
			 System.out.println("Using Query");
			 Query query=session.createQuery("FROM Employee");
			 employeeList= criteria.list();
			 employeeList.forEach(emp->{
				 
				 System.out.println(emp.getId()+" "+emp.getFirstName());
			 });
			 
			 session.close();
			 System.exit(0);
	}

}
