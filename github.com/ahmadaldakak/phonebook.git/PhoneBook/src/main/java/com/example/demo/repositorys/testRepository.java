package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Test;

public interface testRepository extends JpaRepository<Test, Integer>{

}
