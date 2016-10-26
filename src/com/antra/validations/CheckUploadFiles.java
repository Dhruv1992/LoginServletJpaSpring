package com.antra.validations;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class CheckUploadFiles {

	private static final String EXTENSIONS_ALLOWED[] = {"application/pdf","application/vnd.ms-excel",     
        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
        "application/msword", 
        "application/vnd.openxmlformats-officedocument.wordprocessingml.document", 
        "text/plain"};
	private static final String PATH_UPLOAD = "C:/Users/Dhruv/Desktop/Upload/";
	
	public String processFiles(MultipartFile file){
		if(!file.isEmpty()){
			if(isValidExtension(file.getContentType())){
				String path = PATH_UPLOAD + file.getOriginalFilename();
				try {
					file.transferTo(new File(path));
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					return "File "+file.getOriginalFilename()+" is not uploaded";
				}
				return "File Successfully uploaded";
			}else{
				return "This format "+file.getContentType()+" is not accepted";
			}
		}else{
			return "Please upload the file";
		}
		
	}
	
	public boolean isValidExtension(String contentType){
		
		if(!Arrays.asList(EXTENSIONS_ALLOWED).contains(contentType)){
			return false;
		}else{
			return true;
		}
	}
}
