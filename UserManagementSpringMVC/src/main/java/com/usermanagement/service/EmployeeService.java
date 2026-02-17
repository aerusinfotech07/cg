package com.usermanagement.service;

import com.usermanagement.dao.EmployeeDAO;
import com.usermanagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    public Employee findById(Long id) {
        return employeeDAO.findById(id);
    }

    public Employee findByEmployeeCode(String employeeCode) {
        return employeeDAO.findByEmployeeCode(employeeCode);
    }

    public Employee findByEmail(String email) {
        return employeeDAO.findByEmail(email);
    }

    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    public void delete(Long id) {
        employeeDAO.deleteById(id);
    }
}
