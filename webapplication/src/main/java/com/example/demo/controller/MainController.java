package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.entity.PhonebookVO;
import com.example.demo.service.PhoneService;


@Controller
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	PhoneService phoneService;

	
	@PostMapping("/phonebook")
    public ResponseEntity<String> insertPhonebook(@RequestBody PhonebookVO phonebook) {
        int result = phoneService.insert(phonebook);
        if (result == 1) {
            return ResponseEntity.ok("Phonebook entry added successfully");
        } else {
            return ResponseEntity.status(500).body("Error adding phonebook entry");
        }
    }
	
	@GetMapping("/phonebook")
	public ResponseEntity<List<PhonebookVO>> getAllPhonebooks() {
	    List<PhonebookVO> list = phoneService.findAll();
	    return ResponseEntity.ok(list);
	}

	
	@GetMapping("/phonebook/search")
	public ResponseEntity<List<PhonebookVO>> searchPhonebook(@RequestParam("name") String name) {
	    List<PhonebookVO> list = phoneService.findByuser(name);
	    return ResponseEntity.ok(list);
	}

	

	@GetMapping("/phonebook/{id}")
	public ResponseEntity<PhonebookVO> getPhonebookById(@PathVariable("id") int id) {
	    Optional<PhonebookVO> phonebook = phoneService.findById(id);
	    
	    // 객체가 존재하면 반환, 없으면 null 반환
	    return phonebook.map(ResponseEntity::ok)
	                    .orElseGet(() -> ResponseEntity.ok(null)); // null로 반환
	}
		
	
	@PutMapping("/phonebook")
	public ResponseEntity<String> updatePhonebook(@RequestBody PhonebookVO phonebook) {
	    int result = phoneService.update(phonebook);
	    if (result == 1) {
	        return ResponseEntity.ok("Phonebook entry updated successfully");
	    } else {
	        return ResponseEntity.status(500).body("Error updating phonebook entry");
	    }
	}
	
	@DeleteMapping("/phonebook/{id}")
	public ResponseEntity<String> deletePhonebook(@PathVariable("id") int id) {
	    int result = phoneService.delete(id);
	    if (result == 1) {
	        return ResponseEntity.ok("Phonebook entry deleted successfully");
	    } else {
	        return ResponseEntity.status(500).body("Error deleting phonebook entry");
	    }
	}


		
	}
	

  