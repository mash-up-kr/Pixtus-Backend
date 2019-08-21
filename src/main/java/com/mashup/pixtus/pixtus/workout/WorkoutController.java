package com.mashup.pixtus.pixtus.workout;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.pixtus.pixtus.workout.dto.ReqWorkoutRegisterDto;
import com.mashup.pixtus.pixtus.workout.service.WorkoutService;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

	private WorkoutService workoutService;

	public WorkoutController(WorkoutService workoutService) {
		this.workoutService = workoutService;
	}

	@PostMapping("")
	public ResponseEntity register(@RequestBody ReqWorkoutRegisterDto requestBody) {
		return ResponseEntity.status(HttpStatus.OK).body(workoutService.registerWorkout(requestBody));
	}

}
