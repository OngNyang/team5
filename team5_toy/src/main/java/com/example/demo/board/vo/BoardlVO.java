package com.example.demo.board.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardlVO {
	private long boardId;
	private String title;
	private String content;
	private Date writeDate;
	private int readCount;
	private int replyCount;
	private int likeCount;
	private long catergoryId;
	private long userId;
	private long masterId;
}

