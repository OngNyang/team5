package com.example.demo.likes.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LikesDto {
//	private long likeId;
	private long boardId;
	private	long userId;
	
}
