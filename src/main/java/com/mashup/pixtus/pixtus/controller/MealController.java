package com.mashup.pixtus.pixtus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.pixtus.pixtus.dto.MealRequest;

@RestController
@RequestMapping("/meal")
public class MealController {

	@PostMapping("")
	public ResponseEntity registerMeal(@RequestBody MealRequest requestBody) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

//	@GetMapping("/history")
//	public void getHistory(@RequestParam int prevWeek) {
//
//	}

}
