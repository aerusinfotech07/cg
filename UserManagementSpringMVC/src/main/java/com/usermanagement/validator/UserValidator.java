package com.usermanagement.validator;

import com.usermanagement.entity.Address;
import com.usermanagement.entity.Company;
import com.usermanagement.entity.User;
import com.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (user.getName() == null || user.getName().trim().isEmpty()) {
            errors.rejectValue("name", "required", "Name is required");
        }

        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            errors.rejectValue("username", "required", "Username is required");
        } else {
            User existingByUsername = userService.findByUsername(user.getUsername());
            if (existingByUsername != null && (user.getId() == null || !existingByUsername.getId().equals(user.getId()))) {
                errors.rejectValue("username", "duplicate", "Username already exists");
            }
        }

        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", "required", "Email is required");
        } else if (!isValidEmail(user.getEmail())) {
            errors.rejectValue("email", "invalid", "Invalid email format");
        } else {
            User existingByEmail = userService.findByEmail(user.getEmail());
            if (existingByEmail != null && (user.getId() == null || !existingByEmail.getId().equals(user.getId()))) {
                errors.rejectValue("email", "duplicate", "Email already exists");
            }
        }

        if (user.getAddress() != null) {
            Address address = user.getAddress();
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

        if (user.getCompany() != null) {
            Company company = user.getCompany();
            if (company.getName() == null || company.getName().trim().isEmpty()) {
                errors.rejectValue("company.name", "required", "Company name is required");
            }
        } else {
            errors.rejectValue("company.name", "required", "Company name is required");
        }
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
}
