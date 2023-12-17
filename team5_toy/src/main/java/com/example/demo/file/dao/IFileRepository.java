package com.example.demo.file.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.file.model.FileVO;

@Repository
@Mapper
public interface IFileRepository {
	void uploadFile(FileVO fileVO);

}
