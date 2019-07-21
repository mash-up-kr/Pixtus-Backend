package com.mashup.pixtus.pixtus.workout.dto;

import com.mashup.pixtus.pixtus.workout.entity.Workout;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResWorkoutHistoryDto {

	private String date;

	private String exerciseName;

	private int totalKcal;

	public ResWorkoutHistoryDto(Workout workout) {
		this.date = workout.getDate();
		this.exerciseName = workout.getExerciseName();
		this.totalKcal = workout.getTotalKcal();
	}

}
