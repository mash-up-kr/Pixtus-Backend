package com.mashup.pixtus.pixtus.meal;

import com.mashup.pixtus.pixtus.jwt.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mashup.pixtus.pixtus.meal.dto.ReqMealDto;

@RestController
@RequestMapping("/meal")
public class MealController {

	private MealService mealService;
	private JwtService jwtService;

	public MealController(MealService mealService, JwtService jwtService) {
		this.mealService = mealService;
		this.jwtService = jwtService;
	}

	@PostMapping("")
	public ResponseEntity register(@RequestBody ReqMealDto requestBody) {
		mealService.registerMeal(requestBody);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}