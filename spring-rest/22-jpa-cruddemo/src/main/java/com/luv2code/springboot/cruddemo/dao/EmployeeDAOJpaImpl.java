package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired                           //Not necessary since spring 5
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public List<Employee> findAll() {
		Query q = entityManager.createQuery("FROM Employee");
		List<Employee> employees = q.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Employee employee = entityManager.find(Employee.class, theId);
		return employee;
	}

	@Override
	public void deleteById(int theId) {
		Query q = entityManager.createQuery("DELETE FROM Employee WHERE id=:employeeId");
		q.setParameter("employeeId", theId);
		q.executeUpdate(); 
	}

	@Override
	public void save(Employee theEmployee) {
		Employee dbEmployee = entityManager.merge(theEmployee);
		theEmployee.setId(dbEmployee.getId());
	}

}
