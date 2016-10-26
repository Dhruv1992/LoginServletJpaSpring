package com.antra.vo;

import org.springframework.web.multipart.MultipartFile;

public class UploadFiles {

	private MultipartFile fileName;

	public UploadFiles() {
		// TODO Auto-generated constructor stub
	}
	
	public UploadFiles(MultipartFile fileName){
		this.fileName = fileName;
	}
	
	public MultipartFile getFileName() {
		return fileName;
	}

	public void setFileName(MultipartFile fileName) {
		this.fileName = fileName;
	}

	

}
