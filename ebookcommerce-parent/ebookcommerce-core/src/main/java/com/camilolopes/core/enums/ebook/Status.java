package com.camilolopes.core.enums.ebook;

public enum Status {
	
	Active("Active"), Inactive("Inactive");
	
	private String value;
	
	Status(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
}
