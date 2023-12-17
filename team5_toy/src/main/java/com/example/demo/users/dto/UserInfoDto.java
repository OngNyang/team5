package com.example.demo.users.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserInfoDto {
	private String email;
	private String nickname;
	private String name;
	private String phoneNumber;
	private Date registerDate;
}
