package com.example.demo.file;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileVO {
	private long	fileId;
	private String	fileName;
	private String	fileSize;
	private String	fileContentType;
	private byte[]	fileData;
	private long	boardId;
}
