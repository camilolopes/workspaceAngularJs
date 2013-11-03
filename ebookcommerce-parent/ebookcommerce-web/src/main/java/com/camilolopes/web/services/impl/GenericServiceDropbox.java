package com.camilolopes.web.services.impl;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.camilolopes.web.services.interfaces.GenericFileService;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.its.easyjavadropbox.api.impl.EasyJavaDropBoxServiceImpl;
import com.its.easyjavadropbox.api.interfaces.EasyJavaDropBoxService;

public class GenericServiceDropbox implements GenericFileService {
	
	private static String slash = "/";
	private String dropboxPath = "/";
	
	private String token;
	
	private EasyJavaDropBoxService easyJavaDropBoxService;
	
	public GenericServiceDropbox(String token, String dropboxPath) {
		this.token = token;
		this.dropboxPath = dropboxPath;
		easyJavaDropBoxService = new EasyJavaDropBoxServiceImpl(dropboxPath + slash , token);
	}
	
	public void writeOnResponse(String fileName, HttpServletResponse response) throws Exception {
		String ident = "l";
		int width = 175;
		int height = 240;
		OutputStream out = response.getOutputStream();
		easyJavaDropBoxService.writeThumbnail(ident, width, height, fileName, out);
	}
	
	public String getToken() {
		return token;
	}

	@Override
	public boolean isExistFile(String fileName) throws FileNotFoundException {
		boolean result=true;
		List<DbxEntry> listFiles;
		try {
			listFiles = easyJavaDropBoxService.searchFile(dropboxPath, fileName);
			if (listFiles!=null&& listFiles.isEmpty()) {
				result = false;
				throw new FileNotFoundException(fileName);
			}
		} catch (DbxException e) {
				e.printStackTrace();
		}
		return result;
	}
	
	public EasyJavaDropBoxService getEasyJavaDropBoxService() {
		return easyJavaDropBoxService;
	}
	
	public String getDropboxPath() {
		return dropboxPath;
	}

	public String getDropboxPath(String filename) {
		return dropboxPath + slash + filename;
	}

}