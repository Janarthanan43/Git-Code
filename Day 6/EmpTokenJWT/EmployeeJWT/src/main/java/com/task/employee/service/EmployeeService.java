package com.task.employee.service;

import java.util.List;

import com.task.employee.model.UserInfo;


public interface EmployeeService {
	public UserInfo addEmployee(UserInfo employee);
	
	public boolean loginEmployee(String username, String password);
	
	public List<UserInfo> getAllEmployees();
	
	public UserInfo getEmployeeById(int empId);
}
