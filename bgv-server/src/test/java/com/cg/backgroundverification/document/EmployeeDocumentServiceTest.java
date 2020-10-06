package com.cg.backgroundverification.document;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import com.cg.backgroundverification.dao.EmployeeDocumentRepo;
import com.cg.backgroundverification.entity.EmployeeDocument;
import com.cg.backgroundverification.exception.EmployeeNotFound;
import com.cg.backgroundverification.service.EmployeeDocumentService;


@SpringBootTest
class EmployeeDocumentServiceTest {
	
	@Autowired
	EmployeeDocumentService bcgservice ;
	
	@MockBean
	EmployeeDocumentRepo bcgRepo ;
	
	@Test
	void testGetById() {
		int id = 200 ;
		EmployeeDocument empDoc = new EmployeeDocument() ;
		empDoc.setEmpId(id);
		
		List<EmployeeDocument> list = new ArrayList<>() ;
		list.add(empDoc) ;
		
		when(bcgRepo.getById(id)).thenReturn(list) ;
		assertEquals(list, bcgservice.getById(id)) ;
	}
	
	@Test
	void testGetByName() {
		EmployeeDocument empDoc = new EmployeeDocument() ;
		empDoc.setEmpId(200);
		empDoc.setEmpName("John");
		Assertions.assertThrows(EmployeeNotFound.class, ()->bcgservice.getByName("Nick")) ;
	}
	
}
