package com.mashup.pixtus.pixtus.workout.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class WorkoutId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7722135956087500652L;

	private String uid;

	private String dateId;

	private int exerciseId;

}
