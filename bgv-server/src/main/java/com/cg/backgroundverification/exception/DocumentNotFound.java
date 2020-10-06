package com.cg.backgroundverification.exception;

@SuppressWarnings("serial")
public class DocumentNotFound extends RuntimeException {

	DocumentNotFound(String msg) {
		super(msg);
	}

}
