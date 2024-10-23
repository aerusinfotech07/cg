package com.cg.user.annotation.manytomany.extracolumn;

import java.util.Date;

import org.hibernate.Session;

import com.cg.util.annotation.HibernateUtil;

public class App2 {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		

		   session.beginTransaction();

		    Stock stock = new Stock();
		    stock.setStockCode("7052");
		    stock.setStockName("PADINI");
		 
		    //assume category id is 7
		    Category category1 = (Category)session.get(Category.class, 7);
		    
		    StockCategory stockCategory = new StockCategory();
		    stockCategory.setStock(stock);
		    stockCategory.setCategory(category1);
		    stockCategory.setCreatedDate(new Date()); //extra column
		    stockCategory.setCreatedBy("system"); //extra column
		        
		    stock.getStockCategories().add(stockCategory);
		        
		    session.save(stock);
		       
		    session.getTransaction().commit();

		    
	}
}

/*
Hibernate: 
    select
        category0_.CATEGORY_ID as CATEGORY1_1_0_,
        category0_.`DESC` as DESC2_1_0_,
        category0_.NAME as NAME1_0_ 
    from
        cgdb.category category0_ 
    where
        category0_.CATEGORY_ID=?
Hibernate: 
    insert 
    into
        cgdb.stock
        (STOCK_CODE, STOCK_NAME) 
    values
        (?, ?)
Hibernate: 
    select
        stockcateg_.CATEGORY_ID,
        stockcateg_.STOCK_ID,
        stockcateg_.CREATED_BY as CREATED1_2_,
        stockcateg_.CREATED_DATE as CREATED2_2_ 
    from
        cgdb.stock_category stockcateg_ 
    where
        stockcateg_.CATEGORY_ID=? 
        and stockcateg_.STOCK_ID=?
Hibernate: 
    insert 
    into
        cgdb.stock_category
        (CREATED_BY, CREATED_DATE, CATEGORY_ID, STOCK_ID) 
    values
        (?, ?, ?, ?)
*/
