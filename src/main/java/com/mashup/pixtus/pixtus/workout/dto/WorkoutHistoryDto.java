package com.mashup.pixtus.pixtus.workout.dto;

import com.mashup.pixtus.pixtus.workout.entity.Workout;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class WorkoutHistoryDto {

	private String dateId;

	private String exerciseName;

	private int totalKcal;

	public WorkoutHistoryDto(Workout workout) {
		this.dateId = workout.getDateId();
		this.exerciseName = workout.getExerciseName();
		this.totalKcal = workout.getTotalKcal();
	}

}
