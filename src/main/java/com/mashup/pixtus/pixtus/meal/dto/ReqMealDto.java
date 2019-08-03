package com.mashup.pixtus.pixtus.meal.dto;

import com.mashup.pixtus.pixtus.meal.entity.MealType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Setter
public class ReqMealDto {
	
	private boolean isSelectedB;

	private boolean isSelectedL;

	private boolean isSelectedD;

	private boolean isSelectedM;

	public boolean isSelected(MealType mealType) {
		switch (mealType) {
		case B:
			return isSelectedB;
		case L:
			return isSelectedL;
		case D:
			return isSelectedD;
		case M:
			return isSelectedM;
		default:
			return false;
		}
	}

}