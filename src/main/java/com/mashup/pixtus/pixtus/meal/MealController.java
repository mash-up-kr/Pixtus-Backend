package com.mashup.pixtus.pixtus.meal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.pixtus.pixtus.meal.dto.ReqMealDto;

@RestController
@RequestMapping("/meal")
public class MealController {

	private MealService mealService;

	public MealController(MealService mealService) {
		this.mealService = mealService;
	}

	@PostMapping("")
	public ResponseEntity register(@RequestBody ReqMealDto requestBody) {
		mealService.registerMeal(requestBody);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}