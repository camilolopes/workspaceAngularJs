package com.camilolopes.web.services.interfaces;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletResponse;

public interface GenericFileService {
	
	public void writeOnResponse(String filename, HttpServletResponse response) throws Exception;

	public boolean isExistFile(String cover) throws FileNotFoundException;
	
}