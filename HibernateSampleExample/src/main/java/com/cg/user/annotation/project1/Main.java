package com.cg.user.annotation.project1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Create an EntityManagerFactory and EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("your-persistence-unit-name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Create an instance of EmployeeService
        EmployeeService employeeService = new EmployeeService(entityManager);

        // Save employee with company and addresses
        employeeService.saveEmployeeWithCompanyAndAddresses();

        // Clean up
        entityManager.close();
        entityManagerFactory.close();
    }
}

