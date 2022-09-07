package com.kushal.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kushal.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
