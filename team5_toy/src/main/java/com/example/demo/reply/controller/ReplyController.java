package com.example.demo.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.reply.model.ReplyVO;
import com.example.demo.reply.service.ReplyService;

@RestController
@RequestMapping("/api/replys")
public class ReplyController {

	private final ReplyService replyService;

	@Autowired
	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}

	// 특정 게시판에 대한 모든 댓글을 가져오는 메서드
	@GetMapping("/board/{boardId}")
	public ResponseEntity<List<ReplyVO>> getRepliesByBoardId(@PathVariable long boardId) {
//		return replyService.getRpliesByBoardId(boardId);
//    	List<ReplyVO> list = replyService.getRepliesByBoardId(boardId);
//    	ResponseEntity<> re = new ResponseEntity<>(replyService.getRepliesByBoardId(boardId);,HttpStatus.OK);
//    	return re;
		return new ResponseEntity<>(replyService.getRepliesByBoardId(boardId), HttpStatus.OK);

//    	return new ResponseEntity<>( ,HttpStatus.OK)
	}

	// 특정 댓글 ID에 해당하는 댓글을 가져오는 메서드
	@GetMapping("/{replyId}")
	public ResponseEntity<ReplyVO> getReplyById(@PathVariable long replyId) {

		return new ResponseEntity<>(replyService.getReplyById(replyId), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ReplyVO> createReply(@RequestBody ReplyVO replyVO) {
		return new ResponseEntity<>(replyService.createReply(replyVO), HttpStatus.OK);
	}

	@PutMapping("/update/{replyId}")
	public ResponseEntity<ReplyVO> updateReply(@PathVariable long replyId, @RequestBody ReplyVO updatedReplyVO) {
	    try {
	        ReplyVO updatedReply = replyService.updateReply(replyId, updatedReplyVO);
	        
	        if (updatedReply != null) {
	            return new ResponseEntity<>(updatedReply, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}



	@DeleteMapping("/delete/{replyId}")
	public ResponseEntity<Void> deleteReply(@PathVariable long replyId) {
		replyService.deleteReply(replyId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}