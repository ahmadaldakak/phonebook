package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Log;
@Repository
public interface LogRepository  extends JpaRepository<Log, Integer> {

}
