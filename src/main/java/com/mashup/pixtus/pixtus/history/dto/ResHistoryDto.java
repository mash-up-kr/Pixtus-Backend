package com.mashup.pixtus.pixtus.history.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResHistoryDto {

    List<MealHistoryDto> mealHistory;

    List<WorkoutHistoryDto> workoutHistory;
    
}
