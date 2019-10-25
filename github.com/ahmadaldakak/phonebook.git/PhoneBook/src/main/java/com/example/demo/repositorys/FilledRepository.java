package com.example.demo.repositorys;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Contact;
import com.example.demo.models.Field;
@Repository
public interface FilledRepository extends JpaRepository<Field, Integer> {
	
	@Transactional
	Long deleteByfieldContact(Contact contact);

}
