package com.example.demo.reply.dao;

import com.example.demo.reply.model.ReplyVO;

import java.util.List;

public interface ReplyDAO {
    List<ReplyVO> getRepliesByBoardId(long boardId);
    ReplyVO getReplyById(long replyId);
    void createReply(ReplyVO replyVO);
    void updateReply(ReplyVO replyVO);
    void deleteReply(long replyId);
}
