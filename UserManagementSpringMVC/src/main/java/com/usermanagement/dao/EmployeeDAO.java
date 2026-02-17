package com.usermanagement.dao;

import com.usermanagement.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Employee> findAll() {
        Query<Employee> query = getSession().createQuery("FROM Employee", Employee.class);
        return query.list();
    }

    public Employee findById(Long id) {
        return getSession().get(Employee.class, id);
    }

    public Employee findByEmployeeCode(String employeeCode) {
        Query<Employee> query = getSession().createQuery("FROM Employee WHERE employeeCode = :code", Employee.class);
        query.setParameter("code", employeeCode);
        return query.uniqueResult();
    }

    public Employee findByEmail(String email) {
        Query<Employee> query = getSession().createQuery("FROM Employee WHERE email = :email", Employee.class);
        query.setParameter("email", email);
        return query.uniqueResult();
    }

    public void save(Employee employee) {
        getSession().saveOrUpdate(employee);
    }

    public void update(Employee employee) {
        getSession().merge(employee);
    }

    public void deleteById(Long id) {
        Employee employee = findById(id);
        if (employee != null) {
            getSession().delete(employee);
        }
    }
}
