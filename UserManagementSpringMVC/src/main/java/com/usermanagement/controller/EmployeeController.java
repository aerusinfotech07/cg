package com.usermanagement.controller;

import com.usermanagement.entity.Address;
import com.usermanagement.entity.Employee;
import com.usermanagement.entity.Geo;
import com.usermanagement.service.EmployeeService;
import com.usermanagement.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeValidator employeeValidator;

    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Employee employee = new Employee();
        employee.setAddress(new Address());
        employee.getAddress().setGeo(new Geo());
        model.addAttribute("employee", employee);
        return "employee/form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee,
                               BindingResult result,
                               Model model) {
        employeeValidator.validate(employee, result);

        if (result.hasErrors()) {
            ensureNestedObjects(employee);
            model.addAttribute("employee", employee);
            return "employee/form";
        }

        if (employee.getId() == null) {
            employeeService.save(employee);
        } else {
            employeeService.update(employee);
        }
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return "redirect:/employees";
        }
        ensureNestedObjects(employee);
        model.addAttribute("employee", employee);
        return "employee/form";
    }

    @GetMapping("/view/{id}")
    public String viewEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return "redirect:/employees";
        }
        model.addAttribute("employee", employee);
        return "employee/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

    private void ensureNestedObjects(Employee employee) {
        if (employee.getAddress() == null) {
            employee.setAddress(new Address());
        }
        if (employee.getAddress().getGeo() == null) {
            employee.getAddress().setGeo(new Geo());
        }
    }
}
