package com.mashup.pixtus.pixtus.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.mashup.pixtus.pixtus.dto.UserSignUpRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
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
		this.prevExp = stage.getPrevExp();
		this.nextExp = stage.getNextExp();
	}

	public void increaseExp(int exp) {
		this.exp += exp;
	}

	public void decreaseExp(int exp) {
		if (this.exp < exp) {
			this.exp = 0;
			return;
		}
		this.exp -= exp;
	}

	public boolean isLevelUp() {
		return this.getExp() >= this.getNextExp();
	}

	public boolean isLevelDown() {
		return this.getExp() < this.getPrevExp();
	}
}
