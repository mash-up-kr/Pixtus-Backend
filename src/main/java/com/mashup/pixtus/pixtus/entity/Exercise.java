package com.mashup.pixtus.pixtus.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int exerciseId;

	private String name;

	private int kcal;

}
