package com.task.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.employee.model.UserInfo;
import com.task.employee.service.EmployeeService;

@RestController
@RequestMapping("api/v1")
public class EmployeeController 
{

	@Autowired
	private EmployeeService es;
	
	
	@GetMapping("/admin/getAllEmployees")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getAllUsers()
	{
		List<UserInfo> empList = es.getAllEmployees();
		
		if(empList !=null)
		{
			return new ResponseEntity<List<UserInfo>>(empList, HttpStatus.OK);
		}
		return new ResponseEntity<String>("list is empty", HttpStatus.OK);
		
	}
	
	@GetMapping("/user/getEmployeeById/{employeeId}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<?> getEmployeeById(@PathVariable("employeeId") int employeeId) {
		UserInfo emp = es.getEmployeeById(employeeId);
		
		if(emp != null) {
			return new ResponseEntity<UserInfo>(emp, HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<String>("Employee not found", HttpStatus.NOT_FOUND);
	}
}

