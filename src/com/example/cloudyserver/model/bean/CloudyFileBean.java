package com.example.cloudyserver.model.bean;

public class CloudyFileBean {
	private String fileName;

	public CloudyFileBean() {
		super();
	}
	
	public CloudyFileBean(String fileName) {
		super();
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
