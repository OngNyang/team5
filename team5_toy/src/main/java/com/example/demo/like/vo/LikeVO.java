package com.example.demo.like.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LikeVO {
	private long likeId;
	private long boardId;
	private long userId;
}
