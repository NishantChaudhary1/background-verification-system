package com.cg.backgroundverification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.backgroundverification.exception.InvalidDetailsException;
import com.cg.backgroundverification.service.VerificationService;

/**
 * 
 * @author Nishant
 * Set the status of documents uploaded by the employee by admin.
 *
 */
@RestController
@RequestMapping("/BackGroundVerification")
@CrossOrigin("http://localhost:4200")
public class VerificationController {

	@Autowired
	VerificationService bcgservice;

	/**
	 * Setting the status of document.
	 * 
	 * @return Verification Object.
	 */
	@ExceptionHandler(InvalidDetailsException.class)
	@PutMapping(value = "/SetStatus/{id}")
	public ResponseEntity<?> setstatus(@RequestBody int id) {
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(bcgservice.setstatus(id));
		} catch (InvalidDetailsException ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
