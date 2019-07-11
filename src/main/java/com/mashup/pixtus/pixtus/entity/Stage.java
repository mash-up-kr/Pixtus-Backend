package com.mashup.pixtus.pixtus.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Stage {

	@Id
	private int level;

	private int prevExp;

	private int nextExp;

}
