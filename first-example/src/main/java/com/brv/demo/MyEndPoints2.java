package com.brv.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyEndPoints2 {

	public MyEndPoints2() {
	}

	@Autowired
	UserDaoService service;
	
	
	@GetMapping("/users")
	public List<User> retrieveAll(){
		return service.findAll();
		
	}
}
