package com.camilolopes.web.services.impl;

import com.camilolopes.web.services.interfaces.EbookImageService;

public class EbookImageServiceDropbox extends GenericServiceDropbox implements EbookImageService {

	private static String ebookDropboxPath = "/ebook";

	public EbookImageServiceDropbox(String token) {
		super(token, ebookDropboxPath);
	}
	
}