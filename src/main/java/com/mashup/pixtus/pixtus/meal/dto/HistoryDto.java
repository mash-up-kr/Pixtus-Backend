package com.mashup.pixtus.pixtus.meal.dto;

import com.mashup.pixtus.pixtus.workout.dto.ResWorkoutHistoryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HistoryDto {

    List<ResMealHistoryDto> mealHistory;

    List<ResWorkoutHistoryDto> workoutHistory;
}
