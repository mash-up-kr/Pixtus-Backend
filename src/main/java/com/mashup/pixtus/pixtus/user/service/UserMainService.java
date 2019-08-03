package com.mashup.pixtus.pixtus.user.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mashup.pixtus.pixtus.jwt.JwtService;
import com.mashup.pixtus.pixtus.user.dto.ResUserMainDto;
import com.mashup.pixtus.pixtus.user.entity.User;
import com.mashup.pixtus.pixtus.workout.WorkoutService;
import com.mashup.pixtus.pixtus.workout.dto.ResWorkoutDto;
import com.mashup.pixtus.pixtus.workout.entity.Workout;

@Service
public class UserMainService {

	private UserService userService;
	private WorkoutService workoutService;
	private JwtService jwtService;
	
	public UserMainService(UserService userService, WorkoutService workoutService, JwtService jwtService) {
		this.userService = userService;
		this.workoutService = workoutService;
		this.jwtService = jwtService;
	}

	public ResUserMainDto getMain() {
		String uid = jwtService.getUid();

		return getMain(uid);
	}

	public ResUserMainDto getMain(String uid) {
		User user = userService.get(uid);

		List<Workout> workouts = workoutService.listToday(uid);

		List<ResWorkoutDto> workoutDtos = workouts.stream().map(ResWorkoutDto::new).collect(Collectors.toList());

		return ResUserMainDto
			.builder()
			.characterName(user.getCharacterName())
			.level(user.getLevel())
			.exp(user.getExp())
			.date(LocalDate.now())
			.nextExp(user.getNextExp())
			.workouts(workoutDtos)
			.build();
	}
	
}