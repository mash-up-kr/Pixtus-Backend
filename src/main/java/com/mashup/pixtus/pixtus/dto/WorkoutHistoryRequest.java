package com.mashup.pixtus.pixtus.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WorkoutHistoryRequest {

	private String uid;

	private int prevWeek;
}
