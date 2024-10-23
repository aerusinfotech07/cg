package com.cg.user.annotation.onetoone;

import java.util.Date;

import org.hibernate.Session;

import com.cg.util.annotation.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();

		stock.setStockCode("7053");
		stock.setStockName("TCS3");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("MyCompany");
		stockDetail.setCompDesc("one stop shopping");
		stockDetail.setRemark("Any Remark");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		session.getTransaction().commit();

		System.out.println("Done");
	}
}