package com.mashup.pixtus.pixtus.meal;

import com.mashup.pixtus.pixtus.meal.dto.HistoryDto;
import com.mashup.pixtus.pixtus.meal.dto.ResMealHistoryDto;
import com.mashup.pixtus.pixtus.util.PixtusUtils;
import com.mashup.pixtus.pixtus.util.StartAndEndDate;
import com.mashup.pixtus.pixtus.workout.WorkoutService;
import com.mashup.pixtus.pixtus.workout.dto.ResWorkoutHistoryDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashup.pixtus.pixtus.meal.dto.ReqMealDto;
import com.mashup.pixtus.pixtus.user.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealService {

    private UserService userService;
    private WorkoutService workoutService;
    private MealRepository mealRepository;

    public MealService(UserService userService, WorkoutService workoutService, MealRepository mealRepository) {
        this.userService = userService;
        this.workoutService = workoutService;
        this.mealRepository = mealRepository;
    }

    private static final int KCAL_PER_MEAL = 700;

    @Transactional
    public void registerMeal(ReqMealDto requestBody) {

        int exp = requestBody.getMealCnt() * KCAL_PER_MEAL;
        userService.decreaseExp(requestBody.getUid(), exp);
    }


    public List<ResMealHistoryDto> makeMealHistoryList(String uid, int prevWeek) {

        StartAndEndDate date = PixtusUtils.getDate(prevWeek);

        return mealRepository
                .findByUidAndDateBetween(uid, date.getStartDate(), date.getEndDate()).stream()
                .map(ResMealHistoryDto::new)
                .collect(Collectors.toList());
    }


    public HistoryDto getHistory(String uid, int prevWeek) {

        List<ResMealHistoryDto> historyList = makeMealHistoryList(uid, prevWeek);
        List<ResWorkoutHistoryDto> workoutList = workoutService.getHistory(uid, prevWeek);

        return new HistoryDto(historyList, workoutList);
    }

}
