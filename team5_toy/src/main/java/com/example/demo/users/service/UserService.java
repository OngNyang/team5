package com.example.demo.users.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.users.dao.IUserRepository;
import com.example.demo.users.dto.UserEmailPwDTO;
import com.example.demo.users.dto.UserInfoDto;
import com.example.demo.users.dto.EditUserDto;
import com.example.demo.users.model.UsersVO;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userDao;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void registerUser(UsersVO user) {
		user.setUserId(selectMaxUserNo() + 1);
		String encodePw = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePw);
		user.setRole("ROLE_USER");
		user.setRegisterDate(new Date());
		userDao.registerUser(user);
	}

	@Override
	public UsersVO selectUser(String email) {
		return userDao.selectUser(email);
	}

	@Override
	public boolean updateUser(EditUserDto user, String email) {
		UsersVO userVO = userDao.selectUser(email);

		if (passwordEncoder.matches(user.getPassword(), userVO.getPassword())) {
			String encodedPW = passwordEncoder.encode(user.getNewPassword());
			user.setNewPassword(encodedPW);
			userDao.updateUser(user.toInfoDto(email));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteUser(String email, String password) {
		UsersVO user = userDao.selectUser(email);

		if (passwordEncoder.matches(password, user.getPassword())) {
			userDao.deleteUser(email);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getPassword(String email) {
		return userDao.getPassword(email);
	}

	@Override
	public long selectMaxUserNo() {
		return userDao.selectMaxUserNo();
	}

	@Override
	public boolean loginUser(UserEmailPwDTO loginDto) {
		UsersVO user = selectUser(loginDto.getEmail());

		return passwordEncoder.matches(loginDto.getPassword(), user.getPassword());
	}

	@Override
	public List<UserInfoDto> getUserList() {
		List<UsersVO> list = userDao.getUserList();
		List<UserInfoDto> result = new ArrayList<>();
		for (UsersVO user : list) {
			result.add(new UserInfoDto(user.getEmail(), user.getNickname(), user.getName(), user.getPhoneNumber(), user.getRegisterDate()));
		}
		return result;
	}
}
