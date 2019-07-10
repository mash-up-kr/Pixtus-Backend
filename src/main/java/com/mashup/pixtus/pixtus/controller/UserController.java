package com.mashup.pixtus.pixtus.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.pixtus.pixtus.dto.UserSignUpRequest;

@RestController
@RequestMapping("/user")
public class UserController {

	@PostMapping("sign-in")
	public void signIn() {
		// uid
	}

	@PostMapping("sign-up")
	public void signUp(@RequestBody UserSignUpRequest requestBody) {
		// TODO 반환 정보 확인
	}

}
