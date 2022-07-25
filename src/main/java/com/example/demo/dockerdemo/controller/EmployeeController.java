package com.example.demo.dockerdemo.controller;

import com.example.demo.dockerdemo.entity.Employee;
import com.example.demo.dockerdemo.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees() {

        List<Employee> employees = repository.findAll();

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {

        Employee employee = repository.findById(id).orElse(null);

        if(ObjectUtils.isEmpty(employee)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(employee);
    }

    @PostMapping("/")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

        Employee newEmployee = repository.save(employee);

        return ResponseEntity.ok(newEmployee);
    }

    @PutMapping("/")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {

        Employee existingEmp = repository.findById(employee.getId()).orElse(null);

        if(ObjectUtils.isEmpty(existingEmp)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if(!ObjectUtils.isEmpty(employee.getFirstName()))
            existingEmp.setFirstName(employee.getFirstName());

        if(!ObjectUtils.isEmpty(employee.getLastName()))
            existingEmp.setLastName(employee.getLastName());

        if(!ObjectUtils.isEmpty(employee.getDepartmentId()))
            existingEmp.setDepartmentId(employee.getDepartmentId());

        if(!ObjectUtils.isEmpty(employee.getNIC()))
            existingEmp.setNIC(employee.getNIC());

        if(!ObjectUtils.isEmpty(employee.getAddress()))
            existingEmp.setAddress(employee.getAddress());

        if(!ObjectUtils.isEmpty(employee.getPhoneNumber()))
            existingEmp.setPhoneNumber(employee.getPhoneNumber());

        Employee updatedEmp = repository.save(existingEmp);

        return ResponseEntity.ok(updatedEmp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) {

        Employee existingEmp = repository.findById(id).orElse(null);

        if(ObjectUtils.isEmpty(existingEmp)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        repository.delete(existingEmp);

        return ResponseEntity.ok("Employee Deleted. " + existingEmp);
    }
}
