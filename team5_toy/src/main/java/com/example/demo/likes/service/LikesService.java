package com.example.demo.likes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.likes.dao.ILikesRepository;
import com.example.demo.likes.model.LikesDto;
import com.example.demo.likes.model.LikesVO;

@Service
public class LikesService implements ILikesService {
	private ILikesRepository likesRepository;
	
	@Autowired
	public LikesService(ILikesRepository likesRepository) {
		this.likesRepository = likesRepository;
	}
	
	@Override
	public LikesVO	insertLikes(LikesDto likesDto) {
//		likesRepository.insertLikes(likesVO);
		
		
//		LikesVO likesVO = likesRepository.selectLikesByBoardIdAndUserId(likesDto);
//		
//		if (likesVO == null) {
//			LikesVO newLikesVO = likesRepository.insertLikes(likesDto);
//			return likesVO;
//		} else {
//			throw new DataIntegrityViolationException(null);
//			
//		}
		
		//있는지 확인.
		//없으면 아이디값 생성해서 vo 만들기
		//레포지토리메서드 사용
		
		LikesVO likesVO = likesRepository.selectLikesByBoardIdAndUserId(likesDto);
		
		if (likesVO == null) {
			likesVO  = new LikesVO(likesRepository.selectMaxLikesId() + 1, likesDto.getBoardId(), likesDto.getUserId());
			likesRepository.insertLikes(likesVO);
			return likesVO;
//			likesRepository.deleteLikes(likesDto);
//			return likesVO;
		} else {
			throw new DataIntegrityViolationException(null);
		}
	}
	
	
	@Override
	public List<LikesVO>	selectLikesByUserId(Long userId) {
		return likesRepository.selectLikesByUserId(userId);
	}
	
	@Override
	public List<LikesVO>	selectLikesByBoardId(Long boardId) {
		return likesRepository.selectLikesByBoardId(boardId);
	}
	
	@Override
	public LikesVO			selectLikesByBoardIdAndUserId(LikesDto likesDto) {
		return likesRepository.selectLikesByBoardIdAndUserId(likesDto);
	}
		
	@Override
	public LikesVO				deleteLikes(LikesDto likesDto) {
		LikesVO likesVO = likesRepository.selectLikesByBoardIdAndUserId(likesDto);
		
		if (likesVO == null) {
			throw new DataIntegrityViolationException(null);
		} else {
			likesRepository.deleteLikes(likesDto);
			return likesVO;
		}
	}
//	
}
