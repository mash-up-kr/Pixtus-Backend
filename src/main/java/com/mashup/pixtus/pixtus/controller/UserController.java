package com.mashup.pixtus.pixtus.controller;

import com.mashup.pixtus.pixtus.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.pixtus.pixtus.dto.MainResponse;
import com.mashup.pixtus.pixtus.dto.UserRequest;
import com.mashup.pixtus.pixtus.dto.UserSignUpRequest;
import com.mashup.pixtus.pixtus.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private MainService mainService;

	@PostMapping("sign-in")
	public ResponseEntity signIn(@RequestBody UserRequest requestBody) {
		if (userService.isExisted(requestBody.getUid())) {
			return ResponseEntity.status(HttpStatus.OK).body(mainService.getMain(requestBody.getUid()));
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@PostMapping("sign-up")
	public ResponseEntity signUp(@RequestBody UserSignUpRequest requestBody) {
		userService.signUp(requestBody);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
