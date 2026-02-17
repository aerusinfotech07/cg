package com.usermanagement.dao;

import com.usermanagement.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<User> findAll() {
        Query<User> query = getSession().createQuery("FROM User", User.class);
        return query.list();
    }

    public User findById(Long id) {
        return getSession().get(User.class, id);
    }

    public User findByUsername(String username) {
        Query<User> query = getSession().createQuery("FROM User WHERE username = :username", User.class);
        query.setParameter("username", username);
        return query.uniqueResult();
    }

    public User findByEmail(String email) {
        Query<User> query = getSession().createQuery("FROM User WHERE email = :email", User.class);
        query.setParameter("email", email);
        return query.uniqueResult();
    }

    public void save(User user) {
        getSession().saveOrUpdate(user);
    }

    public void update(User user) {
        getSession().merge(user);
    }

    public void delete(User user) {
        getSession().delete(user);
    }

    public void deleteById(Long id) {
        User user = findById(id);
        if (user != null) {
            delete(user);
        }
    }
}
