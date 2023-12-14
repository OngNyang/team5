package com.example.demo.users.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsersVO {
	private long userId;
	private String email;
	private String password;
	private String nickname;
	private String name;
	private String role;
	private String phoneNumber;
	private Date registerDate;
	
	private long gradeId;
}
