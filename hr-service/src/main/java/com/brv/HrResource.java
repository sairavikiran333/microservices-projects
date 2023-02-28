package com.brv;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HrResource {

	public HrResource() {
		// TODO Auto-generated constructor stub
	}
	
	List<Employee> employees = Arrays.asList(
			new Employee("E1", "Ram", "Kumar", "MedTech"),
			new Employee("E2", "Raj", "Kumar", "Surgery"),
			new Employee("E3", "Anu", "Kumar", "Dentist"));
	
	@RequestMapping("/employees")
	public EmployeeList getEmployees(){
		EmployeeList empList = new EmployeeList();
		empList.setEmployeeList(employees);
		return empList;
	}
	
	
	@RequestMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") String id) {
		Employee emp = employees.stream().filter(e->id.equals(e.getId())).
				findAny().orElse(null);
		return emp;
	}
	
			

}
