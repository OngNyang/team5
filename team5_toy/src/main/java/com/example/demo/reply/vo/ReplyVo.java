package com.example.demo.reply.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyVo {
    private long replyId;
    private Date replyWritedate;
    private String replyContent;
    private long boardId;
    private long userId;
    private long parentId;


}
