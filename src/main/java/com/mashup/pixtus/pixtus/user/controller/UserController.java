package com.mashup.pixtus.pixtus.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.pixtus.pixtus.user.dto.ReqUserDto;
import com.mashup.pixtus.pixtus.user.dto.ReqUserSignUpDto;
import com.mashup.pixtus.pixtus.user.service.UserMainService;
import com.mashup.pixtus.pixtus.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMainService mainService;

	@PostMapping("/sign-in")
	public ResponseEntity signIn(@RequestBody ReqUserDto requestBody) {
		if (userService.isExisted(requestBody.getUid())) {
			return ResponseEntity.status(HttpStatus.OK).body(mainService.getMain(requestBody.getUid()));
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@PostMapping("/sign-up")
	public ResponseEntity signUp(@RequestBody ReqUserSignUpDto requestBody) {
		userService.signUp(requestBody);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
