package com.mashup.pixtus.pixtus.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class UserSignUpRequest {

	private String uid;

	private String email;

	private String name;

	private String characterName;

	private String height;

	private String weight;

	private String gender;

}
