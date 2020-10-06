package com.cg.backgroundverification.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.backgroundverification.entity.EmployeeDocument;

/**
 * Employee Repository.
*/
@Repository
public interface EmployeeDocumentRepo extends JpaRepository<EmployeeDocument,Integer>{
	
	/* Retrieve list of employees with given id. */
	@Query("select e from EmployeeDocument e  where e.empId=?1 ")
	public List<EmployeeDocument> getById(int id);

	/* Retrieve list of employees with given name. */
	@Query("select employee from EmployeeDocument employee  where empName=?1 ")
	public List<EmployeeDocument> getByName(String name);
	
}
