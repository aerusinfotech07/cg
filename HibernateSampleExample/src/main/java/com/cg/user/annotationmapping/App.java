package com.cg.user.annotationmapping;

import org.hibernate.Session;

import com.cg.util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        Stock stock = new Stock();
        
        stock.setStockCode("47153");
        stock.setStockName("TCS");
        
        session.save(stock);
        session.getTransaction().commit();
    }
}