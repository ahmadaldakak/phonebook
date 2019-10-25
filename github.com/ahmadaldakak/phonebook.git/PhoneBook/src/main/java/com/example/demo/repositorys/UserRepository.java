package com.example.demo.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Department;
import com.example.demo.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByPassword(String password);
	List<User> findByuserDepartment(Department department);
	List<User> findByemail(String email);
}
