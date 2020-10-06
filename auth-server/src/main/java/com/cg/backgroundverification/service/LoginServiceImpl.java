package com.cg.backgroundverification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.backgroundverification.dao.LoginDaoRepository;
import com.cg.backgroundverification.entity.LoginDto;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDaoRepository logindao;
	
	@Override
	public LoginDto authentication(int empId, String password,int roleid) {
		return logindao.authentication(empId,password,roleid);
	}

	@Override
	public LoginDto addEmployee(LoginDto employee) {
		return logindao.save(employee) ;
	}

}