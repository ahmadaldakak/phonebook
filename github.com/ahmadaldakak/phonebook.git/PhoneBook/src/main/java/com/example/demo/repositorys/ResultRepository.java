package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Result;
@Repository
public interface ResultRepository extends JpaRepository<Result, Integer>{

}
