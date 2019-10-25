package com.example.demo.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.field_types;;
@Repository
public interface FieldTypesRepository extends JpaRepository<field_types, Integer> {
	List<field_types> findByparent(field_types parent);
	List<field_types> findByid(int id);
}
