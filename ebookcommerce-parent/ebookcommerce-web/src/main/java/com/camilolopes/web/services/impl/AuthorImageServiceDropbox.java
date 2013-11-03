package com.camilolopes.web.services.impl;

import com.camilolopes.web.services.interfaces.AuthorImageService;

public class AuthorImageServiceDropbox extends GenericServiceDropbox implements AuthorImageService {
	
	private static String authorDropboxPath = "/author";

	public AuthorImageServiceDropbox(String token) {
		super(token, authorDropboxPath);
	}
	
}