package com.mashup.pixtus.pixtus.workout.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mashup.pixtus.pixtus.exercise.entity.Exercise;
import com.mashup.pixtus.pixtus.workout.dto.ReqWorkoutRegisterDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Workout {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int workoutId;

	private String uid;

	private String date;

	private int exerciseId;

	private String exerciseName;

	private int time;

	private int totalKcal;

	private Workout(ReqWorkoutRegisterDto requestBody, String date, Exercise exercise) {
		this.uid = requestBody.getUid();
		this.date = date;
		this.exerciseId = requestBody.getExerciseId();
		this.exerciseName = exercise.getName();
		this.time = 0;
		this.totalKcal = 0;
	}

	public static Workout from(ReqWorkoutRegisterDto requestBody, String date, Exercise exercise) {
		return new Workout(requestBody, date, exercise);
	}

	public void updateWorkout(int time, int totalKcal) {
		this.time += time;
		this.totalKcal += totalKcal;
	}
}
