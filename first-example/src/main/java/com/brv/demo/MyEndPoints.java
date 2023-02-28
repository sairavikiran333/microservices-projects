package com.brv.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyEndPoints {
	public MyEndPoints() {
	}

	@RequestMapping("/first")
	public String myString() {
		return "my first project";
	}

	@RequestMapping("/second")
	public String myName(@RequestParam String name) {
		return "Hello :" + name;
	}

	@RequestMapping(path = "/secondpathvariable/{name}")
	public String sayHello2(@PathVariable String name) {
		return "Hello again " + name;
	}
	
	@GetMapping(path = "sampleBean")
	public SecondSampleBean sampleBean() {
		return new SecondSampleBean("Hyd Campus");
	}
	

}
