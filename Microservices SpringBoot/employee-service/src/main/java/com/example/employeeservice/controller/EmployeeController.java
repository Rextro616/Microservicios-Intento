package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> add(@RequestBody Employee employee){
        LOGGER.info("Employee add: {}", employee);
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> findAll(){
        LOGGER.info("Employee find");
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Long id){
        LOGGER.info("Employee find: id={}", id);
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Employee>> getByDepartmentId(@PathVariable("departmentId") Long id){
        LOGGER.info("Employee find: departmentId={}", id);
        return new ResponseEntity<>(employeeService.findByDepartment(id), HttpStatus.OK);
    }
}
