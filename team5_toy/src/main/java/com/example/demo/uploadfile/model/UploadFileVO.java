package com.example.demo.uploadfile.model;

import java.sql.Timestamp;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UploadFileVO {
	private int fileId;		// 파일 아이디, 1씩 증가
	private int boardId;		// 첨부파일이 있는 게시글의 아이디(글번호)
	private String fileName;	// 파일 이름
	private long fileSize;		// 파일 크기
	private String fileContentType;	// 파일 타입(MIME Type)
	private byte[] fileData;		// 파일 데이터
}
	