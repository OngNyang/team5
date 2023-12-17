package com.example.demo.reply.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.reply.dao.ReplyDAO;
import com.example.demo.reply.model.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	private ReplyDAO replyDAO;
	
	@Autowired
	public ReplyServiceImpl(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}
	

    private final List<ReplyVO> replyList = new ArrayList<>();
    
    
    @Override
    public List<ReplyVO> getRepliesByBoardId(long boardId) {
        
		/* List<ReplyVO> list = replyDAO.getRepliesByBoardId(boardId); */
    	return replyDAO.getRepliesByBoardId(boardId); 
    	
    }
    // 특정 댓글 ID에 해당하는 댓글
    @Override
    public ReplyVO getReplyById(long replyId){
    	return replyDAO.getReplyById(replyId);
    }

    // 댓글 작성 
    @Override
    public ReplyVO createReply(ReplyVO replyVO) {
    	return replyVO;
    }

    @Override
    public ReplyVO updateReply(long replyId, ReplyVO updatedReplyVO) {
    	
    	updatedReplyVO.setReplyId(replyId);
    	
    	replyDAO.updateReply(updatedReplyVO);
    	
    	return updatedReplyVO;
        
    }
 


    @Override
    public void deleteReply(long replyId) {
        replyDAO.deleteReply(replyId);
    }
}