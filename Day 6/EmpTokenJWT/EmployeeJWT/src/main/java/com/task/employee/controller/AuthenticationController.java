package com.task.employee.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.employee.service.EmployeeService;
import com.task.employee.service.JwtService;

import com.task.employee.model.UserInfo;


@RestController
@RequestMapping("auth/user")
public class AuthenticationController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addUser(@RequestBody UserInfo user)
	{
		if(employeeService.addEmployee(user)!=null)
		{
			return new ResponseEntity<UserInfo>(user, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Employee not added", HttpStatus.CONFLICT);
	}
	
	
	@PostMapping("/login")
	public String Login(@RequestBody UserInfo employee)
	{
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(employee.getUsername(), employee.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(employee.getUsername());
		}else {
			throw new UsernameNotFoundException("Invalid User");
		}
		
	}
}

