package com.example.demo.file.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileVO {
   	private int fileId;		// 파일 아이디, 1씩 증가
	private String fileName;	// 파일 이름
	private long fileSize;		// 파일 크기
	private String fileContentType;	// 파일 타입(MIME Type)
	private byte[] fileData;		// 파일 데이터
    
}
