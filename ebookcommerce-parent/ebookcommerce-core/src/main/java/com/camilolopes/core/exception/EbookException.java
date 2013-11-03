package com.camilolopes.core.exception;

import com.camilolopes.core.exception.enums.EbookMessageResponse;

@SuppressWarnings("serial")
public class EbookException extends Exception {

	private Exception rootException;
	
	private EbookMessageResponse ebookMessageResponse; 
	
	public EbookException(Exception rootException, EbookMessageResponse ebookMessageResponse) {
		this.rootException = rootException;
		this.ebookMessageResponse = ebookMessageResponse;
	}
	
	public Exception getRootException() {
		return rootException;
	}
	
	public EbookMessageResponse getEbookMessageResponse() {
		return ebookMessageResponse;
	}
	
	@Override
	public String getMessage() {
		return getRootException().getMessage();
	}
	
	@Override
	public String toString() {
		return getEbookMessageResponse().toString();
	}
	
}