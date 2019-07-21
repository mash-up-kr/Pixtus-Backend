package com.mashup.pixtus.pixtus.exercise.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	private int kcal;

}
