package com.cg.backgroundverification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.backgroundverification.exception.EmployeeNotFound;
import com.cg.backgroundverification.service.EmployeeDocumentService;

/**
 * 
 * @author Nishant 
 * Controller class for getting documents of employees by name and Id.
 *
 */

@RestController
@RequestMapping("/BackGroundVerification")
@CrossOrigin("http://localhost:4200")
public class EmployeeDocumentController {

	@Autowired
	EmployeeDocumentService bcgservice;

	/**
	 * Getting the employee document by employee id.
	 * 
	 * @return List of Employee Documents.
	 */
	@ExceptionHandler(EmployeeNotFound.class)
	@GetMapping(value = "/GetDocumentById/{enter-id}")
	public ResponseEntity<?> getById(@PathVariable("enter-id") int id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(bcgservice.getById(id));
		} catch (EmployeeNotFound ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Getting the employee document by employee name.
	 * 
	 * @return List of Employee Documents.
	 */
	@ExceptionHandler(EmployeeNotFound.class)
	@GetMapping(value = "/GetDocumentByName/{enter-name}")
	public ResponseEntity<?> getByName(@PathVariable("enter-name") String name) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(bcgservice.getByName(name));
		} catch (EmployeeNotFound ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

}
