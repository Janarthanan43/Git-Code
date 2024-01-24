package com.task.employee.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.task.employee.model.UserInfo;
import com.task.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserInfo addEmployee(UserInfo employee) {
		// TODO Auto-generated method stub
		if(employee!=null) {
			employee.setPassword(passwordEncoder.encode(employee.getPassword()));
			employeeRepository.save(employee);
			return employee;
		}
		return null;
	}

	@Override
	public boolean loginEmployee(String username, String password) {
		// TODO Auto-generated method stub
		List<UserInfo> employee = employeeRepository.validateEmployee(username, password);
		if(employee.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<UserInfo> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public UserInfo getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		UserInfo employee = employeeRepository.findById(empId).orElse(null);
		if(employee != null) {
			return employee;
		}
		return null;
	}

}

