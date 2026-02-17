package com.cg.user.annotation.single;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cg.util.annotation.HibernateUtil;

public class App {
	
public static void main(String[] args) {
		
        System.out.println("Hibernate many to many (Annotation)");
	Session session = HibernateUtil.getSessionFactory().openSession();

	 Transaction tx= session.beginTransaction();
	 
	Stock stock = new Stock();
        stock.setStockCode("7052");
        stock.setStockName("PADINI");
        session.save(stock);
        tx.commit();
        System.out.println("End");
}


}
