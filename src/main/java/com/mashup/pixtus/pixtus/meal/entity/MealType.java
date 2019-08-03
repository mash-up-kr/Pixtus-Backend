package com.mashup.pixtus.pixtus.meal.entity;

public enum MealType {

	// BreakFast(아침), Lucnh(점심), Dinner(저녁), MidnightSnack(야식)
	B(400), L(700), D(700), M(500);

	private int kcal;

	private MealType(int kcal) {
		this.kcal = kcal;
	}

	public int getKcal() {
		return kcal;
	}
}
