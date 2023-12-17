package com.example.demo.likes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class LikesVO {
	private long likeId;
	private long boardId;
	private long userId;
}
