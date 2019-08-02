package com.mashup.pixtus.pixtus.history.dto;

import com.mashup.pixtus.pixtus.meal.dto.MealHistoryDto;
import com.mashup.pixtus.pixtus.workout.dto.WorkoutHistoryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResHistoryDto {

    List<MealHistoryDto> mealHistory;

    List<WorkoutHistoryDto> workoutHistory;


}
