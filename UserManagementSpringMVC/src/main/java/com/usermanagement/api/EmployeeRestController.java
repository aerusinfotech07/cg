package com.usermanagement.api;

import com.usermanagement.entity.Employee;
import com.usermanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST API controller for Employee resources.
 * Base path: /api/employees
 */
@RestController
@RequestMapping(value = "/api/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody("Employee not found with id: " + id));
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/code/{employeeCode}")
    public ResponseEntity<?> getEmployeeByCode(@PathVariable String employeeCode) {
        Employee employee = employeeService.findByEmployeeCode(employeeCode);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody("Employee not found with code: " + employeeCode));
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getEmployeeByEmail(@PathVariable String email) {
        Employee employee = employeeService.findByEmail(email);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody("Employee not found with email: " + email));
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        if (employee.getId() != null) {
            return ResponseEntity.badRequest().body(errorBody("ID must be null for create"));
        }
        employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee existing = employeeService.findById(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody("Employee not found with id: " + id));
        }
        employee.setId(id);
        employeeService.update(employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody("Employee not found with id: " + id));
        }
        employeeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private static Map<String, String> errorBody(String message) {
        Map<String, String> body = new HashMap<>();
        body.put("message", message);
        return body;
    }
}
