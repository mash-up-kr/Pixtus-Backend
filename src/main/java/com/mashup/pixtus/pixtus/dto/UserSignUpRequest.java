package com.mashup.pixtus.pixtus.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserSignUpRequest {

	private String uid;

	private String email;

	private String name;

	private String characterName;

	private int height;

	private int weight;

	private String gender;

}
