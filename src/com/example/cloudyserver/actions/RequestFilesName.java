package com.example.cloudyserver.actions;

import java.util.List;

import javax.servlet.ServletContext;

import com.example.cloudyserver.model.bean.CloudyFile;
import com.example.cloudyserver.model.biz.CloudyFileManager;
import com.opensymphony.xwork2.Action;

import net.sf.json.JSONArray;

public class RequestFilesName implements Action {

	private List<CloudyFile> cloudyFiles;
    private String jsonResult;
    
    private int isAbs;
    
	public List<CloudyFile> getCloudyFiles() {
		return cloudyFiles;
	}

	public void setCloudyFiles(List<CloudyFile> cloudyFiles) {
		this.cloudyFiles = cloudyFiles;
	}

	public String getJsonResult() {
		return jsonResult;
	}
	
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public int isAbs() {
		return isAbs;
	}

	public void setAbs(int isAbs) {
		this.isAbs = isAbs;
	}

	@Override
	public String execute() throws Exception {
		cloudyFiles = CloudyFileManager.getInstance().getFilesName(isAbs);
//		jsonResult = JSONArray.fromObject(cloudyFiles).toString();
		
		return SUCCESS;
	}
}
