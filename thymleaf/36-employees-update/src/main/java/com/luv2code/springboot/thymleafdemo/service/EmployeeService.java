package com.luv2code.springboot.thymleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymleafdemo.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(int theId);

	public void deleteById(int theId);

	public void save(Employee theEmployee);
}
