package com.swingdemo.service;

import java.util.List;

import com.swingdemo.model.Employee;

public interface EmployeeService {

 boolean addEmp(Employee emp);

 boolean deleteEmp(int id);

 boolean updateEmp(Employee emp);

 Employee getById(int id);

 List<Employee> getAllEmp();

 List<Employee> search(String input);
 
}