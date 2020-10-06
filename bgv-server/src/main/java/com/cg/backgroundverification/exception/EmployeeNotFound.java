package com.cg.backgroundverification.exception;

@SuppressWarnings("serial")
public class EmployeeNotFound extends RuntimeException {

	public EmployeeNotFound(String msg) {
		super(msg);
	}
}
