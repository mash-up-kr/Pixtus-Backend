package com.mashup.pixtus.pixtus.history;

import com.mashup.pixtus.pixtus.history.dto.ResHistoryDto;
import com.mashup.pixtus.pixtus.meal.dto.MealHistoryDto;
import com.mashup.pixtus.pixtus.workout.dto.WorkoutHistoryDto;
import com.mashup.pixtus.pixtus.workout.service.WorkoutService;
import com.mashup.pixtus.pixtus.meal.MealService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final MealService mealService;
    private final WorkoutService workoutService;


    public ResHistoryDto get(String uid, int prevWeek) {

        LocalDate startLocalDate = getStartDate(prevWeek);

        String startDate = startLocalDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String endDate = getEndDate(startLocalDate, prevWeek).format(DateTimeFormatter.BASIC_ISO_DATE);

        List<MealHistoryDto> mealHistoryList = mealService.getHistory(uid, startDate, endDate);
        List<WorkoutHistoryDto> workoutHistoryList = workoutService.getHistory(uid, startDate, endDate);

        return new ResHistoryDto(mealHistoryList, workoutHistoryList);
    }


    private LocalDate getStartDate(int prevWeek) {
        LocalDate today = LocalDate.now();
        int todayValue = today.getDayOfWeek().getValue();

        return today.minusWeeks(prevWeek + 1).plusDays(7 - todayValue);
    }

    private LocalDate getEndDate(LocalDate startDate, int prevWeek) {
        if (prevWeek == 0)
            return LocalDate.now();

        return startDate.plusDays(6);
    }

}
