package com.example.demo.users.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.users.dto.EditUserDto;
import com.example.demo.users.dto.EditUserResultDto;
import com.example.demo.users.dto.RegisterResultDto;
import com.example.demo.users.dto.UserInfoDto;
import com.example.demo.users.model.UsersVO;
import com.example.demo.users.service.IUserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<RegisterResultDto> registerUser(@RequestBody UsersVO user) {
		
		try {
			userService.registerUser(user);
		} catch(Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		return ResponseEntity.ok(new RegisterResultDto(user.getEmail(), user.getNickname()));
	}
	
	@GetMapping("/info")
	public ResponseEntity<Object> getUserInfo(Principal principal) {
		UsersVO user = userService.selectUser(principal.getName());
		System.out.println(user);
		if (user == null) {
			return ResponseEntity.status(400).body("사용자 정보 조회 실패");
		}
		return ResponseEntity.ok(new UserInfoDto(
				user.getEmail(), user.getNickname(), user.getName(), user.getPhoneNumber(), user.getRegisterDate()));
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<UserInfoDto>> getUserlist() {
		return ResponseEntity.ok(userService.getUserList());
	}
	
	@PutMapping("/update")
	public ResponseEntity<EditUserResultDto> editUser(@RequestBody EditUserDto user, Principal principal) {
		boolean result = userService.updateUser(user, principal.getName());
		
		if (result) {
			return ResponseEntity.ok(user.toResultDto());
		} else {
			return ResponseEntity.status(400).body(null);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteUser(@RequestBody Map<String, String> passwordMap, Principal principal) {
		boolean result = userService.deleteUser((String) principal.getName(), passwordMap.get("password"));
		
		if (result) {
			return ResponseEntity.ok("Delete Success");
		} else {
			return ResponseEntity.status(400).body("Delete Fail");
		}
	}
	
	@GetMapping("/login/result")
	public ResponseEntity<String> loginUserResult() {
		return ResponseEntity.ok("로그인 성공");
	}
	
	@GetMapping("/logout/result")
	public ResponseEntity<String> logoutUserResult() {
		return ResponseEntity.ok("로그아웃 성공");
	}
}
