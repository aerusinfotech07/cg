package com.cg.user.annotation.onetomany;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.cg.util.annotation.HibernateUtil;

public class App {
	public static void main(String[] args) {
		
        System.out.println("Hibernate one to many (Annotation)");
	Session session = HibernateUtil.getSessionFactory().openSession();

	session.beginTransaction();

	Stock stock = new Stock();
        stock.setStockCode("70524");
        stock.setStockName("PADINI4");
        session.save(stock);
        
        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setPriceOpen(new Float("1.3"));
        stockDailyRecords.setPriceClose(new Float("1.3"));
        stockDailyRecords.setPriceChange(new Float("12.0"));
        stockDailyRecords.setVolume(3000000L);
        stockDailyRecords.setDate(new Date());
        
      
        
        
        
        
      
        
        
        
        stockDailyRecords.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecords);
        
        
        session.save(stockDailyRecords);
        

	session.getTransaction().commit();
	System.out.println("Done");
	}
}

