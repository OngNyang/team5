package com.example.demo.user.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {
	private long userId;
	private String id;
	private String password;
	private String nickname;
	private String name;
	private String email;
	private String phoneNumber;
	private Date registerDate;
	
	private long gradeId;
}
