package com.cg.user.annotation.onetoone;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.cg.user.annotation.single.Employee;
import com.cg.util.annotation.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		/*
		 * Stock stock = new Stock();
		 * 
		 * stock.setStockCode("7053"); stock.setStockName("TCS3");
		 * 
		 * 
		 * StockDetail stockDetail = new StockDetail();
		 * stockDetail.setCompName("MyCompany");
		 * stockDetail.setCompDesc("one stop shopping");
		 * stockDetail.setRemark("Any Remark"); stockDetail.setListedDate(new Date());
		 * 
		 * stock.setStockDetail(stockDetail); stockDetail.setStock(stock);
		 * 
		 * 
		 * session.save(stock); session.getTransaction().commit();
		 */
		 System.out.println("Using Criteria");
		 Criteria criteria=session.createCriteria(Stock.class);
		 List<Stock> employeeList= criteria.list();
		 employeeList.forEach(emp->{
			 
			 System.out.println(emp);
			 //System.out.println(emp.getStockDetail());
		 });

		System.out.println("Done");
		System.exit(0);
	}
}