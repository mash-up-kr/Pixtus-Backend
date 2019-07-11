package com.mashup.pixtus.pixtus.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mashup.pixtus.pixtus.dto.WorkoutRequest;

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

	private Workout (WorkoutRequest requestBody, String date, Exercise exercise){
		this.uid = requestBody.getUid();
		this.date = date;
		this.exerciseId = requestBody.getExerciseId();
		this.exerciseName = exercise.getName();
		this.time = 0;
		this.totalKcal = 0;
	}

	public static Workout from(WorkoutRequest requestBody, String date, Exercise exercise){
		return new Workout(requestBody, date, exercise);
	}

	public void updateWorkout(int time, int totalKcal) {
		this.time += time;
		this.totalKcal += totalKcal;
	}
}
