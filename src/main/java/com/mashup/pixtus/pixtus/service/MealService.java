package com.mashup.pixtus.pixtus.service;

import com.mashup.pixtus.pixtus.dto.MealRequest;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    private UserService userService;

    public MealService(UserService userService) {
        this.userService = userService;
    }

    private static final int KCAL_PER_MEAL = 700;

    public void registerMeal(MealRequest requestBody){
        int exp = requestBody.getMealCnt() * KCAL_PER_MEAL;
        userService.decreaseExp(requestBody.getUid(), exp);
    }

}
