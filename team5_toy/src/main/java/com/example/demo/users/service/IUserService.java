package com.example.demo.users.service;

import com.example.demo.users.dto.UserEmailPwDTO;
import com.example.demo.users.dto.UserInfoDto;

import java.util.List;

import com.example.demo.users.dto.EditUserDto;
import com.example.demo.users.model.UsersVO;

public interface IUserService {
	long selectMaxUserNo();
	void registerUser(UsersVO user);
	UsersVO selectUser(String email);
	boolean updateUser(EditUserDto user, String email);
	boolean deleteUser(String email, String password);
	String getPassword(String email);
	boolean loginUser(UserEmailPwDTO loginDto);
	List<UserInfoDto> getUserList();
}
