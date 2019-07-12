package com.mashup.pixtus.pixtus.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MainResponse {

	private String characterName;

	private int exp;

	private int nextExp;

	private LocalDate date;

	private List<WorkoutDto> workouts;

}
