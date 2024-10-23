package com.cg.user.annotation.project1;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EmployeeService {

    private EntityManager entityManager;

    public EmployeeService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveEmployeeWithCompanyAndAddresses() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            Company company = new Company();
            company.setName("Tech Corp");

            Address companyAddress = new Address();
            companyAddress.setStreet("123 Tech Lane");
            companyAddress.setCity("Silicon Valley");
            company.setAddress(companyAddress);

            Employee employee = new Employee();
            employee.setName("John Doe");
            employee.setCompany(company);

            Address homeAddress = new Address();
            homeAddress.setStreet("456 Elm Street");
            homeAddress.setCity("Springfield");
            homeAddress.setEmployee(employee);

            Address workAddress = new Address();
            workAddress.setStreet("789 Oak Avenue");
            workAddress.setCity("Metropolis");
            workAddress.setEmployee(employee);

            employee.setAddresses(Set.of(homeAddress, workAddress));

            entityManager.persist(company);  // Cascades to persist the address
            entityManager.persist(employee);   // Cascades to persist addresses

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
    
    
    
    
    
}
