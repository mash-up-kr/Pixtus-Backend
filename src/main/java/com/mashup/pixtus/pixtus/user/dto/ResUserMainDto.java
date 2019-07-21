package com.mashup.pixtus.pixtus.user.dto;

import java.time.LocalDate;
import java.util.List;

import com.mashup.pixtus.pixtus.workout.dto.ResWorkoutDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResUserMainDto {

	private String characterName;

	private int level;

	private int exp;

	private int nextExp;

	private LocalDate date;

	private List<ResWorkoutDto> workouts;

}
