package com.kushal.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kushal.springboot.cruddemo.dao.EmployeeDAO;
import com.kushal.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDAO employeeDAO;
	@Autowired
	public void EmployeeService(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeDAO.deleteById(theId);
	}

}
