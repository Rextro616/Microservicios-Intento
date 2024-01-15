package com.example.departmentservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
//@Entity puede usarse para conectar una base de datos
public class Department {
    private Long id;

    private String name;

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
