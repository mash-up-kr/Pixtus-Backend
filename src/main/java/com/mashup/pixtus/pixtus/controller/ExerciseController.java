package com.mashup.pixtus.pixtus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.pixtus.pixtus.dto.ExerciseResponse;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

	@GetMapping("")
	public ResponseEntity list() {
		return ResponseEntity.status(HttpStatus.OK).body(new ExerciseResponse());
	}

}
