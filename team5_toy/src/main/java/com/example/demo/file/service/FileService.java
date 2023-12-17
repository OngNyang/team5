package com.example.demo.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.file.dao.IFileRepository;
import com.example.demo.file.model.FileVO;

@Service
public class FileService implements IFileService {
	private IFileRepository fileRepository;
	
	@Autowired
	public FileService(IFileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}
	@Override
	public void uploadFile(FileVO fileVO) {
		fileRepository.uploadFile(fileVO);
	}
	
}
