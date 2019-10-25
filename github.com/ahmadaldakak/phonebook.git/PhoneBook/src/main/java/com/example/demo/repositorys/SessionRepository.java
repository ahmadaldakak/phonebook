package com.example.demo.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Sessions;

public interface SessionRepository extends JpaRepository<Sessions, Integer>{

	List<Sessions> findBysessionKey(String sessionKey);
}
