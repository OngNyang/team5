package com.example.demo.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EditUserResultDto {
	private String newPassword;
	private String nickname;
	private String name;
	private String phoneNumber;
}
