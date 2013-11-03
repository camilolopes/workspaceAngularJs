package com.its.easyjavadropbox.api.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxEntry.File;
import com.dropbox.core.DbxEntry.WithChildren;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.its.easyjavadropbox.api.interfaces.EasyJavaDropBox;

public class EasyJavaDropBoxImpl implements EasyJavaDropBox{
	private String root = "/";
	private String dropboxPath = root;
	private DbxRequestConfig config;
	private DbxEntry.WithChildren listing = null;
	private DbxClient client;
	

	public EasyJavaDropBoxImpl(String dropboxPath,String token) {
		this.dropboxPath = dropboxPath;
		config = new DbxRequestConfig("JavaTutorial/1.0",	Locale.getDefault().toString());
		client = new DbxClient(config, token);
	}
	
	@Override
	public void changeDropboxPath(String newpath) {
		dropboxPath = newpath;
		
	}

	public WithChildren getListing() throws DbxException{
			 listing = client.getMetadataWithChildren(dropboxPath);
		return listing;
	}

	public  List<DbxEntry> searchFile(String basePath, String query) throws DbxException{
		List<DbxEntry> listFileAndFolderNames = new ArrayList<DbxEntry>();
			listFileAndFolderNames = client.searchFileAndFolderNames(basePath, query);
		return listFileAndFolderNames; 
	}

	@Override
	public List<DbxEntry> listFiles() throws DbxException {
				DbxEntry.WithChildren listFiles = client.getMetadataWithChildren(dropboxPath);
		return  listFiles.children;
	}

	@Override
	public File getFile() {
		
		return null;
	}
	
	public DbxClient getClient() {
		return client;
	}

}
