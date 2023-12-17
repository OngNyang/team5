package com.example.demo.likes.service;

import java.util.List;

import com.example.demo.likes.model.LikesDto;
import com.example.demo.likes.model.LikesVO;

public interface ILikesService {
//	void			insertLikes(LikesVO likesVO);
	LikesVO			insertLikes(LikesDto likesDto);
	List<LikesVO>	selectLikesByUserId(Long userId);
	List<LikesVO>	selectLikesByBoardId(Long boardId);
	LikesVO				deleteLikes(LikesDto likesDto);
	LikesVO			selectLikesByBoardIdAndUserId(LikesDto likesDto);

}
