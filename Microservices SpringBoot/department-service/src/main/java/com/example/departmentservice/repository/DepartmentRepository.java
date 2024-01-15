package com.example.departmentservice.repository;

import com.example.departmentservice.model.Department;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Esta interfaz solo será usada al usar una DB
public interface DepartmentRepository extends JpaRepository<Integer, Department> {

}
