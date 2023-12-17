package com.example.demo.likes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.likes.model.LikesDto;
import com.example.demo.likes.model.LikesVO;
import com.example.demo.likes.service.ILikesService;

@RestController
@RequestMapping("/")
public class LikesController {
	private ILikesService likesService;
	
	@Autowired
	public LikesController(ILikesService likesService) {
		this.likesService = likesService;
	}
	
	@PostMapping("/likes/insert")
	public ResponseEntity<LikesVO> createLikes(@RequestBody LikesDto likesDto) {
//		LikesVO likesVO = likesService.insertLikes(likesDto);
//		return new ResponseEntity<>(likesVO, HttpStatus.CREATED);
		
		try {
			LikesVO createdLikesVO = likesService.insertLikes(likesDto);
			return new ResponseEntity<>(createdLikesVO, HttpStatus.CREATED);
		} catch(DataIntegrityViolationException e) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}
	
	@GetMapping("/likes/user/{userId}")
	public ResponseEntity<List<LikesVO>> getLikesByUserId(@PathVariable Long userId) {
		List<LikesVO> list = likesService.selectLikesByUserId(userId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/likes/board/{boardId}")
	public ResponseEntity<List<LikesVO>> getLikesByBoardId(@PathVariable Long boardId) {
		return new ResponseEntity<>(likesService.selectLikesByBoardId(boardId), HttpStatus.OK);
	}

	@PostMapping("/likes/boardanduser")
	public ResponseEntity<LikesVO> getLikesByBoardIdAndUserId(@RequestBody LikesDto likesDto) {
		LikesVO likesVO = likesService.selectLikesByBoardIdAndUserId(likesDto);
		System.out.println(likesVO);
		return new ResponseEntity<>(likesVO, HttpStatus.OK);
	}
	
	// userId, boardId를 JSON으로 받아와서 삭제 
	@DeleteMapping("/likes/delete")
	public ResponseEntity<LikesVO> deleteLikes(@RequestBody LikesDto likesDto) {
		try {
			LikesVO deletedLikesVO = likesService.deleteLikes(likesDto);
			return new ResponseEntity<>(deletedLikesVO, HttpStatus.OK);
		} catch(DataIntegrityViolationException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
