package com.mashup.pixtus.pixtus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.pixtus.pixtus.dto.WorkoutRequest;
import com.mashup.pixtus.pixtus.service.WorkoutService;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

	private WorkoutService workoutService;

	public WorkoutController(WorkoutService workoutService) {
		this.workoutService = workoutService;
	}

	@PostMapping("")
	public ResponseEntity register(@RequestBody WorkoutRequest requestBody) {
		return ResponseEntity.status(HttpStatus.OK).body(workoutService.registerWorkout(requestBody));
	}

	@GetMapping("/history")
	public ResponseEntity getHistory(@RequestParam String uid, @RequestParam(defaultValue = "0") int prevWeek) {
		return ResponseEntity.status(HttpStatus.OK).body(workoutService.getHistory(uid, prevWeek));
	}

}
