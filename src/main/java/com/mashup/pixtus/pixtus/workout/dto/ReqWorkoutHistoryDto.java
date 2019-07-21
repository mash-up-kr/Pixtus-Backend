package com.mashup.pixtus.pixtus.workout.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReqWorkoutHistoryDto {

	private String uid;

	private int prevWeek;
}
