package com.camilolopes.web.util;

public class FileExtensionHelper {

	private static String dot = ".";
	
	public static String addPdfExtension(String fileName) {
		String extension = "pdf";
		return addExtension(fileName, dot + extension);
	}
	
	public static String addExtension(String fileName, String fileExtension) {
		if (fileName.endsWith(fileExtension)) {
			fileName = fileName.replaceAll(fileExtension, "");
		}
		fileName = fileName + fileExtension;
		return fileName;
	}

}