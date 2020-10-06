package com.cg.backgroundverification.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.backgroundverification.dao.VerificationRepo;
import com.cg.backgroundverification.entity.Verification;
import com.cg.backgroundverification.exception.InvalidDetailsException;

@Service
public class VerificationServiceImpl implements VerificationService {

	@Autowired
	VerificationRepo bcgstatusdao;

	@Override
	public Verification setstatus(int id) {
		Verification verobj = bcgstatusdao.findById(id).orElse(null);
		if (verobj == null) {
			throw new InvalidDetailsException("Invalid Id") ;
		}
		long millis = System.currentTimeMillis();
		Date enddate = new Date(millis);
		verobj.setEndDate(enddate);
		verobj.setStatus("Verified");
		bcgstatusdao.save(verobj);
		return verobj;
	}
}
