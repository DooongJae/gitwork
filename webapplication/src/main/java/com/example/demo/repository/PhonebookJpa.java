package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PhonebookVO;

public interface PhonebookJpa extends JpaRepository<PhonebookVO, Integer> {

	List<PhonebookVO> findByNameContaining(String name);
	
	
	 
	 
}
