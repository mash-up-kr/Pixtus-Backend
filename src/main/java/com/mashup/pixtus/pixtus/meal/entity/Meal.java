package com.mashup.pixtus.pixtus.meal.entity;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mealId;

	private String uid;

	private String dateId;

	@Enumerated(EnumType.STRING)
	private MealType type;

	private int totalKcal;

	public Meal(String uid, String dateId, MealType type, int totalKcal) {
		this.uid = uid;
		this.dateId = dateId;
		this.type = type;
		this.totalKcal = totalKcal;
	}

}
