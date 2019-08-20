package com.mashup.pixtus.pixtus.workout.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.mashup.pixtus.pixtus.exercise.entity.Exercise;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@IdClass(WorkoutId.class)
public class Workout {

	@Id
	private String uid;

	@Id
	private String dateId;

	@Id
	private int exerciseId;

	private String exerciseName;

	private int amount;

	private int totalKcal;

	private Workout(String uid, String dateId, Exercise exercise) {
		this.uid = uid;
		this.dateId = dateId;
		this.exerciseId = exercise.getExerciseId();
		this.exerciseName = exercise.getName();
		this.amount = 0;
		this.totalKcal = 0;
	}

	public static Workout from(String uid, String dateId, Exercise exercise) {
		return new Workout(uid, dateId, exercise);
	}

	public void updateWorkout(int amount, int kcal) {
		this.amount += amount;
		this.totalKcal += kcal;
	}
}
