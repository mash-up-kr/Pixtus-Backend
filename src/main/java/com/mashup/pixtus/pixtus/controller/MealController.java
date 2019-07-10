package com.mashup.pixtus.pixtus.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.pixtus.pixtus.dto.MealRequest;

@RestController
@RequestMapping("/meal")
public class MealController {

	@PostMapping("")
	public void registerMeal(@RequestBody MealRequest requestBody) {
		// TODO 유저 정보 반환 여부 확인
	}

//	@GetMapping("/history")
//	public void getHistory(@RequestParam int prevWeek) {
//
//	}

}
