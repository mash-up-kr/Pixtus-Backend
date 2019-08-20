package com.mashup.pixtus.pixtus.exercise.service;

public class TimeKcalCalculator implements KcalCalculator {

	@Override
	public int calculateKcal(int measure, int amount) {
		return measure * getMin(amount);
	}

	private int getMin(int second) {
		return second / 60;
	}

}
