package com.luv2code.springboot.thymleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private List<Employee> employees;
	
	@PostConstruct
	public void loadData() {
		Employee e1 = new Employee(1,"Jithin","M V","jithin@gmail.com");
		Employee e2 = new Employee(2,"Jishnu","M V","jishnu@gmail.com");
		Employee e3 = new Employee(3,"praveen","M V","praveen@gmail.com");
		Employee e4 = new Employee(4,"Prasad","M V","prasad@gmail.com");
		
		employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees", employees);
		return "list-employees";
	}
}
