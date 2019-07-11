package com.mashup.pixtus.pixtus.controller;

import com.mashup.pixtus.pixtus.dto.WorkoutHistoryRequest;
import com.mashup.pixtus.pixtus.dto.WorkoutRegisterResponse;
import com.mashup.pixtus.pixtus.service.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mashup.pixtus.pixtus.dto.WorkoutHistoryResponse;
import com.mashup.pixtus.pixtus.dto.WorkoutRequest;

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
	public ResponseEntity getHistory(@ModelAttribute WorkoutHistoryRequest workoutHistoryRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(new WorkoutHistoryResponse());
	}

}
