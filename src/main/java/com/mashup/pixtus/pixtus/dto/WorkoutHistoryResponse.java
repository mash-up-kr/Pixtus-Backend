package com.mashup.pixtus.pixtus.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WorkoutHistoryResponse {

	private String date;

	private String exerciseName;

	private int totalKcal;

	public WorkoutHistoryResponse(String date, String exerciseName, int totalKcal) {
		
	}
	
}
