package com.example.departmentservice.service;

import com.example.departmentservice.model.Department;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository //Al no conectar la DB utilizaré el servicio como un repositorio
public class DepartmentService {
    private List<Department> departments = new ArrayList<>(); //Será ek storage que sustituye a la DB por el momento

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department findById(Long id){
        return departments.stream()
                .filter(department ->
                        department.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> allDepartments(){
        return departments;
    }

}
