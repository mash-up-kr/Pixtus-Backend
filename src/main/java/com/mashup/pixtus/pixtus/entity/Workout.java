package com.mashup.pixtus.pixtus.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Getter
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

}
