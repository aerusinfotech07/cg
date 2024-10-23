package com.cg.util.annotation;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cg.user.User;

public class HibernateUtil2 {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure(); // Load hibernate.cfg.xml
            configuration.addAnnotatedClass(User.class); // Add your annotated classes
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
