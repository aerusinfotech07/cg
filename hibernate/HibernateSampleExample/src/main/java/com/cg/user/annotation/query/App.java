package com.cg.user.annotation.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cg.util.annotation.HibernateUtil;

public class App {
	
public static void main(String[] args) {
		
        System.out.println("Hibernate QUERY)");
	Session session = HibernateUtil.getSessionFactory().openSession();

	session.beginTransaction();

	//1. HQL Select Query Example
	//Retrieve a stock data where stock code is “70524”.


	/*Query query = session.createQuery("from Stock where stockCode = :code ");
	query.setParameter("code", "70524");
	List list = query.list();
System.out.println(list);
*/
	/*Query query = session.createQuery("from Stock where stockCode = '7277' ");
	List list = query.list();

	//2. HQL Update Query Example
	//Update a stock name to “DIALOG1” where stock code is “7277”.


	Query query = session.createQuery("update Stock set stockName = :stockName" +
	    				" where stockCode = :stockCode");
	query.setParameter("stockName", "DIALOG1");
	query.setParameter("stockCode", "7277");
	int result = query.executeUpdate();
*/

	Query query = session.createQuery("update com.cg.user.annotation.query.Stock set stockName = 'DIALOG2'" +
	    				" where stockCode = '70524'");
	int result = query.executeUpdate();
	System.out.println(result);
	//session.beginTransaction().commit();
/*
	//3. HQL Delete Query Example
	//Delete a stock where stock code is “7277”.


	Query query = session.createQuery("delete Stock where stockCode = :stockCode");
	query.setParameter("stockCode", "7277");
	int result = query.executeUpdate();


	Query query = session.createQuery("delete Stock where stockCode = '7277'");
	int result = query.executeUpdate();

	//4. HQL Insert Query Example
	//In HQL, only the INSERT INTO … SELECT … is supported; there is no INSERT INTO … VALUES. HQL only support insert from another table. For example


	//"insert into Object (id, name) select oo.id, oo.name from OtherObject oo"; 

	//Insert a stock record from another backup_stock table. This can also called bulk-insert statement.


	Query query = session.createQuery("insert into Stock(stock_code, stock_name)" +
	    			"select stock_code, stock_name from backup_stock");
	int result = query.executeUpdate();

	//The query.executeUpdate() will return how many number of record has been inserted, updated or deleted.
	session.getTransaction().commit();
*/
	System.out.println("Done");
}


}
