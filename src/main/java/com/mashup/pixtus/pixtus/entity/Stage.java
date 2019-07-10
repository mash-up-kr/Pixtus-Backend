package com.mashup.pixtus.pixtus.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Getter
public class Stage {

	@Id
	private int level;

	private int nextExp;

}
