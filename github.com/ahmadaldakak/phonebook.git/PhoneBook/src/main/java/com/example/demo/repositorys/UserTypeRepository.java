package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserType;;
@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

}
