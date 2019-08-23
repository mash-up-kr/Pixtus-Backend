package com.mashup.pixtus.pixtus.workout.dto;

import com.mashup.pixtus.pixtus.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResWorkoutRegisterDto {

//	@Setter
	private int exp;

	private int currExp;

	private int nextExp;

//	public ResWorkoutRegisterDto(User user) {
//		this.currExp = user.getExp();
//		this.nextExp = user.getNextExp();
//	}

}
