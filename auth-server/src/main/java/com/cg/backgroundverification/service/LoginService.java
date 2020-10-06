package com.cg.backgroundverification.service;

import com.cg.backgroundverification.entity.LoginDto;

public interface LoginService {

	public LoginDto authentication(int id, String pass,int roleid);

	public LoginDto addEmployee(LoginDto employee) ;
}
