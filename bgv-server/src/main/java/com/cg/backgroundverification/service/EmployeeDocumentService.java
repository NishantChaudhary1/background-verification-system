package com.cg.backgroundverification.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cg.backgroundverification.entity.EmployeeDocument;
import com.cg.backgroundverification.entity.Verification;

public interface EmployeeDocumentService {

	public List<EmployeeDocument> getById(int id);

	public List<EmployeeDocument> getByName(String name);

	EmployeeDocument uploadFile(MultipartFile file, String user);

	Verification checkstatus(int id);

}
