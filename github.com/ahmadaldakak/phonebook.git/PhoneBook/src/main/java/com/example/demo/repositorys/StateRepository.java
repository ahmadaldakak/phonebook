package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.State;;
@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
