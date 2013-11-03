package com.camilolopes.web.util;

import org.codehaus.jackson.annotate.JsonProperty;

import com.camilolopes.core.exception.enums.EbookMessageResponse;

@SuppressWarnings("serial")
public class AjaxMsg implements java.io.Serializable {

	private String message;
	
	public AjaxMsg(){}
	
	public AjaxMsg(String message) {
		this.message = message;
	}

	public AjaxMsg(EbookMessageResponse ebookMessageResponse) {
		this.message = ebookMessageResponse.toString();
	}
	
	@JsonProperty("message")
	public String getMessage() {
		return message;
	}
	
	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setMessage(EbookMessageResponse ebookMessageResponse) {
		this.message = ebookMessageResponse.toString();
	}

}
