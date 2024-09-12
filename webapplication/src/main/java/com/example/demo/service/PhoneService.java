package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PhonebookVO;
import com.example.demo.repository.PhonebookJpa;

@Service
public class PhoneService {

	@Autowired
	PhonebookJpa jpa;

	


	public int insert(PhonebookVO phonebook) {
		try {
			jpa.save(phonebook);
			return 1; // 성공
		} catch (Exception e) {
			e.printStackTrace();
			return 0; // 실패
		}
	}
	
	public List<PhonebookVO> findAll() {

		return jpa.findAll();
	}

	public List<PhonebookVO> findByuser(String name) {
		return jpa.findByNameContaining(name);
	}

	public Optional<PhonebookVO> findById(int id) {
	    try {
	        return jpa.findById(id);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Optional.empty();
	    }
	}

	public int update(PhonebookVO phonebook) {
	    try {
	        jpa.save(phonebook);
	        return 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}

	public int delete(int id) {
	    try {
	        jpa.deleteById(id);
	        return 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}





}



