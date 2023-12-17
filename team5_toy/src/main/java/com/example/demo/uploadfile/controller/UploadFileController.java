package com.example.demo.uploadfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.vo.BoardlVO;
import com.example.demo.uploadfile.model.UploadFileVO;
import com.example.demo.uploadfile.service.IUploadFileService;

@RestController
@RequestMapping("/file")
public class UploadFileController {
//	private IUploadFileService	uploadFileService;
//	
//	@Autowired
//	public UploadFileController(IUploadFileService uploadFileService) {
//		this.uploadFileService = uploadFileService;
//	}
//	
//	@PostMapping("/upload")
//	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
//		return null;
//		
//	}
	

	
}
