package com.cg.backgroundverification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.backgroundverification.entity.LoginDto;
import com.cg.backgroundverification.exception.InvalidDetailsException;
import com.cg.backgroundverification.service.LoginService;

@RestController
@RequestMapping("/BackGroundVerification")
@CrossOrigin("http://localhost:4200")
public class BackGroundVerifierController {

	@Autowired
	LoginService loginservice;

	/* Login using id and password */
	@GetMapping(value = "/Login/{enter-userid}/{password}/{role-id}")
	public LoginDto authentication(@PathVariable("enter-userid") int id, @PathVariable("password") String pass,
			@PathVariable("role-id") int roleid) throws InvalidDetailsException {
		LoginDto loginobj = loginservice.authentication(id, pass, roleid);
		if (loginobj != null) {
			return loginobj;
		} else {
			throw new InvalidDetailsException("No records found with the given login credentials!!!");

		}

	}
	
	@PostMapping(value = "/new", consumes = { "application/json" })
	public LoginDto addEmployee(@RequestBody LoginDto employee) {
		return loginservice.addEmployee(employee);
	}
	
	
}
