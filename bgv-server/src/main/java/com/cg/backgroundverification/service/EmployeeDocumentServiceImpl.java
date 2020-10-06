package com.cg.backgroundverification.service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cg.backgroundverification.dao.EmployeeDocumentRepo;
import com.cg.backgroundverification.dao.VerificationRepo;
import com.cg.backgroundverification.entity.EmployeeDocument;
import com.cg.backgroundverification.entity.Verification;
import com.cg.backgroundverification.exception.EmployeeNotFound;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Nishant
 * Service Implementation class.
 *
 */


@Service
public class EmployeeDocumentServiceImpl implements EmployeeDocumentService {

	@Autowired
	EmployeeDocumentRepo bcgdao;

	@Autowired
	VerificationRepo statusdaoobj;

	/* Getting the employee document by employee id. */
	@Override
	public List<EmployeeDocument> getById(int id) {
		List<EmployeeDocument> docList = bcgdao.getById(id);
		if (docList.isEmpty()) {
			throw new EmployeeNotFound("No Employee found for given Id: " + id);
		}
		return docList;
	}

	/* Getting the employee document by employee name. */
	@Override
	public List<EmployeeDocument> getByName(String name) {
		List<EmployeeDocument> docList = bcgdao.getByName(name);
		if (docList.isEmpty()) {
			throw new EmployeeNotFound("No Employee found for given Name: " + name);
		}
		return docList;
	}

	/* Check Document status. */
	@Override
	public Verification checkstatus(int id) {
		return statusdaoobj.findById(id).get();
	}

	/* Upload document in image format with employee Id and name. */
	public EmployeeDocument uploadFile(MultipartFile file, String user) {
		EmployeeDocument dbfile = new EmployeeDocument();
		try {
			dbfile = new ObjectMapper().readValue(user, EmployeeDocument.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		try {
			dbfile.setDocData(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		dbfile.setDocType(file.getOriginalFilename());
		bcgdao.save(dbfile);
		Verification verobj = new Verification();
		verobj.setStatus("pending");
		long millis = System.currentTimeMillis();
		Date startdate = new Date(millis);
		verobj.setStartDate(startdate);
		verobj.getVerfId();
		dbfile.setVerificationdto(verobj);
		statusdaoobj.save(verobj);
		return dbfile;

	}

}
