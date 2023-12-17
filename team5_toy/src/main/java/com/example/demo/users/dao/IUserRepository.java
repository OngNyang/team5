package com.example.demo.users.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.demo.users.dto.EditUserInfoDto;
import com.example.demo.users.model.UsersVO;

@Repository
@Mapper
public interface IUserRepository {
	long selectMaxUserNo();
	void registerUser(UsersVO user);
	UsersVO selectUser(String email);
	void updateUser(EditUserInfoDto user);
	void deleteUser(String email);
	String getPassword(String email);
}
