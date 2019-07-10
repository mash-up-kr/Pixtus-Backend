package com.mashup.pixtus.pixtus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.pixtus.pixtus.dto.WorkoutHistoryResponse;
import com.mashup.pixtus.pixtus.dto.WorkoutRequest;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

	@PostMapping("")
	public ResponseEntity register(@RequestBody WorkoutRequest requestBody) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/history")
	public ResponseEntity getHistory(@RequestParam int prevWeek) {
		return ResponseEntity.status(HttpStatus.OK).body(new WorkoutHistoryResponse());
	}

}
