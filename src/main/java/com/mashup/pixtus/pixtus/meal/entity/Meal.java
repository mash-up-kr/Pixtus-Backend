package com.mashup.pixtus.pixtus.meal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Meal {

	@Id
	private int mealId;

	private String uid;

	private String date;

	@Enumerated(EnumType.STRING)
	private MealType type;

	private int totalKcal;

}
