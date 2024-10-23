package com.cg.user.annotation.manytomany.extracolumn;

import java.util.Date;

import org.hibernate.Session;

import com.cg.util.annotation.HibernateUtil;

public class App1 {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();

	    Stock stock = new Stock();
	    stock.setStockCode("7052");
	    stock.setStockName("PADINI");
	 
	    Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
	    //new category, need save to get the id first
	    session.save(category1);
	    
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
    insert 
    into
        mkyongdb.category
        (`DESC`, NAME) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        mkyongdb.stock
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
        mkyongdb.stock_category stockcateg_ 
    where
        stockcateg_.CATEGORY_ID=? 
        and stockcateg_.STOCK_ID=?
Hibernate: 
    insert 
    into
        mkyongdb.stock_category
        (CREATED_BY, CREATED_DATE, CATEGORY_ID, STOCK_ID) 
    values
        (?, ?, ?, ?)
*/
