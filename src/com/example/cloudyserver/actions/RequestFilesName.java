package com.example.cloudyserver.actions;

import java.util.List;

import javax.servlet.ServletContext;

import com.example.cloudyserver.model.bean.CloudyFileBean;
import com.example.cloudyserver.model.biz.CloudyFileManager;
import com.opensymphony.xwork2.Action;

import net.sf.json.JSONArray;

public class RequestFilesName implements Action {

	private List<CloudyFileBean> cloudyFiles;
    
    private int isAbs;//是否是需要包含文件绝对路径，0否，1是
    
	public List<CloudyFileBean> getCloudyFiles() {
		return cloudyFiles;
	}

	public void setCloudyFiles(List<CloudyFileBean> cloudyFiles) {
		this.cloudyFiles = cloudyFiles;
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
		
		return SUCCESS;
	}
}
