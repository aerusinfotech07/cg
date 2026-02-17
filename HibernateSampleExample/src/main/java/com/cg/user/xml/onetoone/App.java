package com.cg.user.xml.onetoone;

import java.util.Date;
import org.hibernate.Session;

import com.cg.util.HibernateUtil;


public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to one (XML mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();

		stock.setStockCode("4715");
		stock.setStockName("TCS");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("GENTING Resort");
		stockDetail.setCompDesc("Best resort in the world");
		stockDetail.setRemark("Nothing Special");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		session.getTransaction().commit();

		System.out.println("Done");
	}
}