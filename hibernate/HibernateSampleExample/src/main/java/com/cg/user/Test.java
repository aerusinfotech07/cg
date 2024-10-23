package com.cg.user;

import java.util.Date;

import org.hibernate.Session;

import com.cg.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		User user = new User();

		user.setUserId(6);
		user.setUsername("Mukesh6");
		user.setCreatedBy("Google6");
		user.setCreatedDate(new Date());

		session.save(user);
		session.getTransaction().commit();

	}

}
