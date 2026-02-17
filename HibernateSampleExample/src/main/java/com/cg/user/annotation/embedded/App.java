package com.cg.user.annotation.embedded;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cg.util.annotation.HibernateUtil;

public class App {

    public static void main(String[] args) {
        System.out.println("Hibernate embedded (Annotation)");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Address address = new Address();
        address.setStreet("221B Baker Street");
        address.setCity("London");
        address.setState("London");
        address.setZip("NW1");

        Employee employee = new Employee();
        employee.setName("John Watson");
        employee.setAddress(address);

        session.save(employee);
        tx.commit();
        session.close();

        System.out.println("End");
    }
}
