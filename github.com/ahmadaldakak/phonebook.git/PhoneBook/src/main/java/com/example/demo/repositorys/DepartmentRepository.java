package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
