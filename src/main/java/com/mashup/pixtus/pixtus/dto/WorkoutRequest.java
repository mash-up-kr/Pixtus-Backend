package com.mashup.pixtus.pixtus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutRequest {

	private String uid;

	private int exerciseId;

	private int time;

}
