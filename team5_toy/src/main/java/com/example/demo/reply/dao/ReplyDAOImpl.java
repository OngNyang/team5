package com.example.demo.reply.dao;

import com.example.demo.reply.model.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

    private final SqlSession sqlSession;

    @Autowired
    public ReplyDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<ReplyVO> getRepliesByBoardId(long boardId) {
        return sqlSession.selectList("com.example.demo.reply.dao.ReplyDAO.getRepliesByBoardId", boardId);
    }

    @Override
    public ReplyVO getReplyById(long replyId) {
        return sqlSession.selectOne("com.example.demo.reply.dao.ReplyDAO.getReplyById", replyId);
    }

    @Override
    public void createReply(ReplyVO replyVO) {
        sqlSession.insert("com.example.demo.reply.dao.ReplyDAO.createReply", replyVO);
    }

    @Override
    public void updateReply(ReplyVO replyVO) {
        sqlSession.update("com.example.demo.reply.dao.ReplyDAO.updateReply", replyVO);
    }

    @Override
    public void deleteReply(long replyId) {
        sqlSession.delete("com.example.demo.reply.dao.ReplyDAO.deleteReply", replyId);
    }
}
