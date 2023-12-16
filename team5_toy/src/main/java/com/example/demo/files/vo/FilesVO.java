package com.example.demo.files.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FilesVO {
	private long	fileId;
	private String	fileName;
	private String	fileSize;
	private String	fileContentType;
	private byte[]	fileData;
	private long	boardId;
}
