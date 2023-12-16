package com.example.demo.reply.service;

import java.util.List;

import com.example.demo.reply.model.ReplyVO;

public interface ReplyService {
    List<ReplyVO> getRepliesByBoardId(long boardId);
    ReplyVO getReplyById(long replyId);
    ReplyVO createReply(ReplyVO replyVO);
    ReplyVO updateReply(long replyId, ReplyVO replyVO);
    void deleteReply(long replyId);
}
