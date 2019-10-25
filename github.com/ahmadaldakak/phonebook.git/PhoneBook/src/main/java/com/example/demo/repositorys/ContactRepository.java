package com.example.demo.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Contact;
import com.example.demo.models.Department;
import com.example.demo.models.State;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	List<Contact> findByContactDepartmentAndState(Department department , State state);
	List<Contact> findByContactDepartment(Department department);
	List<Contact> findByState(State state);
}
