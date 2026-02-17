package com.usermanagement.validator;

import com.usermanagement.entity.Address;
import com.usermanagement.entity.Employee;
import com.usermanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;

        if (employee.getName() == null || employee.getName().trim().isEmpty()) {
            errors.rejectValue("name", "required", "Name is required");
        }

        if (employee.getEmployeeCode() == null || employee.getEmployeeCode().trim().isEmpty()) {
            errors.rejectValue("employeeCode", "required", "Employee Code is required");
        } else {
            Employee existingByCode = employeeService.findByEmployeeCode(employee.getEmployeeCode());
            if (existingByCode != null && (employee.getId() == null || !existingByCode.getId().equals(employee.getId()))) {
                errors.rejectValue("employeeCode", "duplicate", "Employee Code already exists");
            }
        }

        if (employee.getEmail() == null || employee.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", "required", "Email is required");
        } else if (!isValidEmail(employee.getEmail())) {
            errors.rejectValue("email", "invalid", "Invalid email format");
        } else {
            Employee existingByEmail = employeeService.findByEmail(employee.getEmail());
            if (existingByEmail != null && (employee.getId() == null || !existingByEmail.getId().equals(employee.getId()))) {
                errors.rejectValue("email", "duplicate", "Email already exists");
            }
        }

        if (employee.getAddress() != null) {
            Address address = employee.getAddress();
            if (address.getStreet() == null || address.getStreet().trim().isEmpty()) {
                errors.rejectValue("address.street", "required", "Street is required");
            }
            if (address.getCity() == null || address.getCity().trim().isEmpty()) {
                errors.rejectValue("address.city", "required", "City is required");
            }
            if (address.getZipcode() == null || address.getZipcode().trim().isEmpty()) {
                errors.rejectValue("address.zipcode", "required", "Zipcode is required");
            }
        } else {
            errors.rejectValue("address.street", "required", "Street is required");
            errors.rejectValue("address.city", "required", "City is required");
            errors.rejectValue("address.zipcode", "required", "Zipcode is required");
        }
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
}
