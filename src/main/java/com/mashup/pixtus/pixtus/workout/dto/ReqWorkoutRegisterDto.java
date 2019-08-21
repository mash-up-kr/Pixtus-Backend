package com.mashup.pixtus.pixtus.workout.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqWorkoutRegisterDto {

	private int exerciseId;

	private int amount;
	

}
