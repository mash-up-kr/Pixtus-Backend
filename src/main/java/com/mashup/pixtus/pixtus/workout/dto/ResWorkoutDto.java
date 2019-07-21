package com.mashup.pixtus.pixtus.workout.dto;

import com.mashup.pixtus.pixtus.workout.entity.Workout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResWorkoutDto {

	private String exerciseName;

	private int totalKcal;

	public ResWorkoutDto(Workout workout) {
		this.exerciseName = workout.getExerciseName();
		this.totalKcal = workout.getTotalKcal();
	}

}
