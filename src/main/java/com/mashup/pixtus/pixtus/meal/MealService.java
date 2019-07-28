package com.mashup.pixtus.pixtus.meal;

import com.mashup.pixtus.pixtus.workout.WorkoutService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashup.pixtus.pixtus.meal.dto.ReqMealDto;
import com.mashup.pixtus.pixtus.user.service.UserService;

@Service
public class MealService {

    private UserService userService;

    public MealService(UserService userService) {
        this.userService = userService;
    }

    private static final int KCAL_PER_MEAL = 700;

    @Transactional
    public void registerMeal(ReqMealDto requestBody) {

        int exp = requestBody.getMealCnt() * KCAL_PER_MEAL;
        userService.decreaseExp(requestBody.getUid(), exp);
    }

}
