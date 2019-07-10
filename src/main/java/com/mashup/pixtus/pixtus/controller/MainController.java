package com.mashup.pixtus.pixtus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.pixtus.pixtus.service.MainService;

@RestController
@RequestMapping("/main")
public class MainController {

	@Autowired
	private MainService mainService;

	@GetMapping("")
	public ResponseEntity get(@RequestParam String uid) {
		return ResponseEntity.status(HttpStatus.OK).body(mainService.getMain(uid));
	}

}
