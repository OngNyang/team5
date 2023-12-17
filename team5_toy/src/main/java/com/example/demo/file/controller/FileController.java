package com.example.demo.file.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.file.model.FileVO;
import com.example.demo.file.service.IFileService;

@RestController
@RequestMapping("/files")
public class FileController {
	private IFileService fileService;
	
	@Autowired
	public FileController(IFileService fileService) {
		this.fileService = fileService;
	}
	
	@PostMapping("/upload")
	public void uploadFile(@RequestParam("file") MultipartFile file) {
		try {
//			FileVO fileVO = new FileVO(1L, file.getOriginalFilename(), file.getBytes());
			FileVO fileVO = new FileVO(1, file.getOriginalFilename(), file.getSize(), file.getContentType(), file.getBytes());
			fileService.uploadFile(fileVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
