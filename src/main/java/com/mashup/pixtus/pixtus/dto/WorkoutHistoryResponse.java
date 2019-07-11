package com.mashup.pixtus.pixtus.dto;

import com.mashup.pixtus.pixtus.entity.Workout;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WorkoutHistoryResponse {

	private String date;

	private String exerciseName;

	private int totalKcal;

	public WorkoutHistoryResponse(Workout workout) {
		this.date = workout.getDate();
		this.exerciseName = workout.getExerciseName();
		this.totalKcal = workout.getTotalKcal();
	}

}
