package com.example.demo.likes.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.likes.model.LikesDto;
import com.example.demo.likes.model.LikesVO;

@Repository
@Mapper
public interface ILikesRepository {
	void			insertLikes(LikesVO likesVO);
	List<LikesVO>	selectLikesByUserId(Long userId);
	List<LikesVO>	selectLikesByBoardId(Long boardId);
	int				deleteLikes(LikesDto likesDto);
	LikesVO			selectLikesByBoardIdAndUserId(LikesDto likesDto);
	long			selectMaxLikesId();
}
