package com.mashup.pixtus.pixtus.history.dto;

import com.mashup.pixtus.pixtus.workout.entity.Workout;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class WorkoutHistoryDto {

	private String date;

	private String exerciseName;

	private int totalKcal;

	public WorkoutHistoryDto(Workout workout) {
		this.date = workout.getDate();
		this.exerciseName = workout.getExerciseName();
		this.totalKcal = workout.getTotalKcal();
	}

}
