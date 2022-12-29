package com.kmb.SpringBootJWT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kmb.SpringBootJWT.Entity.UserEntity;
import com.kmb.SpringBootJWT.Entity.UserRequest;
import com.kmb.SpringBootJWT.Entity.UserResponse;
import com.kmb.SpringBootJWT.Service.IUserService;
import com.kmb.SpringBootJWT.Util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service; // HAS-A

	@Autowired
	private JwtUtil util;

	// 1. save user dava into database
	// http://localhost:8080/user/save
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody UserEntity user) {

		Integer id = service.saveUser(user);
		String body = "User '" + id + "' Saved Successfully ";
		return new ResponseEntity<String>(body, HttpStatus.CREATED);
		// return ResponseEntity.ok(body);
	}

	// validate user and generate token(login)
	@PostMapping("login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest request) {

		// TODO : validate user name/ password with database
		String token = util.generateToken(request.getUsername());
		return ResponseEntity.ok(new UserResponse(token, "Token was created Successfully"));
	}
}
