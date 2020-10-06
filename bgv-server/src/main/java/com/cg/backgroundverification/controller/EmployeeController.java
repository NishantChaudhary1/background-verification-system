package com.cg.backgroundverification.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.backgroundverification.entity.EmployeeDocument;
import com.cg.backgroundverification.entity.Response;
import com.cg.backgroundverification.entity.Verification;
import com.cg.backgroundverification.exception.InvalidDetailsException;
import com.cg.backgroundverification.service.EmployeeDocumentService;

@RestController
@RequestMapping("/BackgroundVerification-EmployeePortal")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
	
	@Autowired 
	EmployeeDocumentService bcgserviceobj;
	
	/*Uploading the document*/
	@PostMapping(value="/UploadDocument",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public 		EmployeeDocument  uploadFile(@RequestParam("file") MultipartFile file,
    		@RequestParam("user") String user ) throws IOException, InvalidDetailsException
    {
    	EmployeeDocument dbperson=bcgserviceobj.uploadFile(file,user);
    	if(dbperson!=null)
    	{
    		return dbperson;
    	}
    	else
    	{
    		throw new InvalidDetailsException("Document Not uploaded");
    	}
    }

	@ExceptionHandler(InvalidDetailsException.class)
	public ResponseEntity<Response> usernotfound1(InvalidDetailsException e)
	{
		return new ResponseEntity<>(new Response(),HttpStatus.OK);
	}

	
	/*checking the status*/
	@GetMapping(value="/ViewStatus/{enter-verfid}")
   	public Verification checkstatus(@PathVariable("enter-verfid") int id) throws InvalidDetailsException
   	{
   	     	return  bcgserviceobj.checkstatus(id);	
   	     	
   	}
	

}
