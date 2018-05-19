package com.javasampleapproach.uploadfiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javasampleapproach.uploadfiles.storage.FileService;

@RestController
public class FileController {
	
	 @Autowired
	 FileService fileservice;
 
	 @CrossOrigin(origins = "http://localhost:4200") 
	 @PostMapping("/profile/uploadpicture")
	 public ResponseEntity < String > handleFileUpload(@RequestParam("file") MultipartFile file) {
		  String message = "";
		  try {
		   fileservice.store(file);
		   message = "You successfully uploaded " + file.getOriginalFilename() + "!";
		   return ResponseEntity.status(HttpStatus.OK).body(message);
		  } catch (Exception e) {
		   message = "Fail to upload Profile Picture" + file.getOriginalFilename() + "!";
		   return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		  }
	 }
 
}