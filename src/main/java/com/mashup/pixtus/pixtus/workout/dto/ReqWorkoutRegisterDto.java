package com.mashup.pixtus.pixtus.workout.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqWorkoutRegisterDto {

	private String uid;

	private int exerciseId;

	private int time;

}
