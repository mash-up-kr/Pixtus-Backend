package com.mashup.pixtus.pixtus.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ReqUserSignUpDto {

	private String uid;

	private String email;

	private String name;

	private String characterName;

	private int height;

	private int weight;

	private String gender;

}
