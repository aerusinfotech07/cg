package com.cg.user.annotation.secondlevelcache;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cg.util.annotation.HibernateUtil;

public class App {

    public static void main(String[] args) {
        System.out.println("Hibernate second-level cache (Annotation)");

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session1.beginTransaction();

        Product product = new Product();
        product.setCode("P-100");
        product.setName("Cached Keyboard");
        session1.save(product);
        tx1.commit();
        session1.close();

        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Product fromDb = (Product) session2.get(Product.class, product.getId());
        System.out.println("Session2 - First load: " + fromDb.getName());
        session2.close();

        Session session3 = HibernateUtil.getSessionFactory().openSession();
        Product fromCache = (Product) session3.get(Product.class, product.getId());
        System.out.println("Session3 - Second load (should use L2 cache): " + fromCache.getName());
        session3.close();

        System.out.println("End");
    }
}
