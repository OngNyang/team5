package com.example.demo.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EditUserDto {
	private String password;
	private String newPassword;
	private String nickname;
	private String name;
	private String phoneNumber;
	
	public EditUserResultDto toResultDto() {
		return new EditUserResultDto(newPassword, nickname, name, phoneNumber);
	}
	
	public EditUserInfoDto toInfoDto(String email) {
		return new EditUserInfoDto(email, newPassword, nickname, name, phoneNumber);
	}
}
