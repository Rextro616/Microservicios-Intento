package com.example.departmentservice.controller;

import com.example.departmentservice.client.EmployeeClient;
import com.example.departmentservice.model.Department;
import com.example.departmentservice.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeClient employeeClient;
    @PostMapping("/add")
    public ResponseEntity<Department> add(@RequestBody Department department){
        LOGGER.info("Department add: {}", department);
        return new ResponseEntity<>(departmentService.addDepartment(department), HttpStatus.OK);
    }

    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<Department>> findAll(){
        LOGGER.info("Department find");
        List<Department> departments
                = departmentService.allDepartments();
        departments.forEach(department ->
                department.setEmployeeList(employeeClient.getByDepartmentId(department.getId())));
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/getDepartment{id}")
    public ResponseEntity<Department> getById(@PathVariable Long id){
        LOGGER.info("Department find: id={}", id);
        return new ResponseEntity<>(departmentService.findById(id), HttpStatus.OK);
    }
}
