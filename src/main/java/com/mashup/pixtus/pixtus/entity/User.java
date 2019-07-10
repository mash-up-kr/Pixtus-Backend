package com.mashup.pixtus.pixtus.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.mashup.pixtus.pixtus.dto.UserSignUpRequest;

import lombok.Getter;

@Entity
@Getter
public class User {

	@Id
	private String uid;

	private String email;

	private String name;

	private String characterName;

	private int height;

	private int weight;

	private String gender;

	private int level;

	private int exp;

	private int prevExp;

	private int nextExp;

//	@JoinColumn
//	@OneToMany
//	List<Workout> workouts;

	private User(UserSignUpRequest reqestBody) {
		this.uid = reqestBody.getUid();
		this.email = reqestBody.getEmail();
		this.name = reqestBody.getName();
		this.characterName = reqestBody.getCharacterName();
		this.height = reqestBody.getHeight();
		this.weight = reqestBody.getWeight();
		this.gender = reqestBody.getGender();
	}

	public static User from(UserSignUpRequest requestBody) {
		return new User(requestBody);
	}

	public void setLevel(Stage stage) {
		this.level = stage.getLevel();
		this.prevExp = this.nextExp;
		this.nextExp = stage.getNextExp();
	}
}
