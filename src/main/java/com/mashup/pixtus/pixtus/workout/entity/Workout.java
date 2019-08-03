package com.mashup.pixtus.pixtus.workout.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mashup.pixtus.pixtus.exercise.entity.Exercise;

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

	private Workout(String uid, String date, Exercise exercise) {
		this.uid = uid;
		this.date = date;
		this.exerciseId = exercise.getExerciseId();
		this.exerciseName = exercise.getName();
		this.time = 0;
		this.totalKcal = 0;
	}

	public static Workout from(String uid, String date, Exercise exercise) {
		return new Workout(uid, date, exercise);
	}

	public void updateWorkout(int time, int totalKcal) {
		this.time += time;
		this.totalKcal += totalKcal;
	}
}
