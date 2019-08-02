package com.mashup.pixtus.pixtus.meal;

import com.mashup.pixtus.pixtus.jwt.JwtService;
import com.mashup.pixtus.pixtus.meal.dto.MealHistoryDto;
import com.mashup.pixtus.pixtus.meal.entity.Meal;
import com.mashup.pixtus.pixtus.workout.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashup.pixtus.pixtus.meal.dto.ReqMealDto;
import com.mashup.pixtus.pixtus.user.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MealService {

    private final UserService userService;
    private final MealRepository mealRepository;
//
//    public MealService(UserService userService) {
//        this.userService = userService;
//    }

    private static final int KCAL_PER_MEAL = 700;

    @Transactional
    public void registerMeal(ReqMealDto requestBody) {

        int exp = requestBody.getMealCnt() * KCAL_PER_MEAL;
        userService.decreaseExp(requestBody.getUid(), exp);
    }

    public List<MealHistoryDto> getHistory(String uid, String startDate, String endDate) {
        return mealRepository.findByUidAndDateBetween(uid, startDate, endDate)
                             .stream()
                             .map(MealHistoryDto::new)
                             .collect(Collectors.toList());
    }

}
