package com.mashup.pixtus.pixtus.exercise.service;

public class StepKcalCalculator implements KcalCalculator {

	@Override
	public int calculateKcal(int measure, int amount) {
		return amount / measure;
	}

}
