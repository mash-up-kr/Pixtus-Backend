package com.mashup.pixtus.pixtus.meal.entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Meal {

	private int mealId;

	private int userId;

	private String date;

	@Enumerated(EnumType.STRING)
	private MealType type;

	private int totalKcal;

}
