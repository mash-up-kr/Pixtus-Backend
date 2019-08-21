package com.mashup.pixtus.pixtus.exercise.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mashup.pixtus.pixtus.exercise.service.KcalCalculator;
import com.mashup.pixtus.pixtus.exercise.service.StepKcalCalculator;
import com.mashup.pixtus.pixtus.exercise.service.TimeKcalCalculator;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int exerciseId;

	private String name;

	private int measure;

	@Enumerated(EnumType.STRING)
	private ExerciseType type;

	private KcalCalculator getCalculator() {
		switch (type) {
		case S:
			return new StepKcalCalculator();
		case T:
			return new TimeKcalCalculator();
		default:
			throw new RuntimeException();
		}
	}

	public int getCalcKcal(int amount) {
		KcalCalculator calculator = getCalculator();

		return calculator.calculateKcal(measure, amount);
	}

}
