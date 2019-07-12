package com.mashup.pixtus.pixtus.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashup.pixtus.pixtus.dto.MealRequest;

@Service
public class MealService {

	private UserService userService;

	public MealService(UserService userService) {
		this.userService = userService;
	}

	private static final int KCAL_PER_MEAL = 700;

	@Transactional
	public void registerMeal(MealRequest requestBody) {
		int exp = requestBody.getMealCnt() * KCAL_PER_MEAL;
		userService.decreaseExp(requestBody.getUid(), exp);
	}

}
