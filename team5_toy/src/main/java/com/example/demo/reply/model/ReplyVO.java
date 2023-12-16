package com.example.demo.reply.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyVO {
    private long replyId;
    private Date replyWritedate;
    private String replyContent;
    private long boardId;
    private long userId;
    private long parentId;


}
