package com.example.cloudyserver.model.bean;

public class CloudyFile {
	private String fileName;

	public CloudyFile() {
		super();
	}
	
	public CloudyFile(String fileName) {
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
