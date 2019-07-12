package com.mashup.pixtus.pixtus.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import com.mashup.pixtus.pixtus.dto.MainResponse;
import com.mashup.pixtus.pixtus.dto.WorkoutDto;
import com.mashup.pixtus.pixtus.entity.User;
import com.mashup.pixtus.pixtus.entity.Workout;

@Service
public class MainService {

	private UserService userService;
	private WorkoutService workoutService;
	
	public MainService(UserService userService, WorkoutService workoutService) {
		this.userService = userService;
		this.workoutService = workoutService;
	}

	public MainResponse getMain(String uid) {
		User user = userService.get(uid);

		List<Workout> workouts = workoutService.listToday(uid);
		
		List<WorkoutDto> workoutDtos = workouts.stream().map(WorkoutDto::new).collect(Collectors.toList());

		return MainResponse
			.builder()
			.characterName(user.getCharacterName())
			.exp(user.getExp())
			.date(LocalDate.now())
			.nextExp(user.getNextExp())
			.workouts(workoutDtos)
			.build();
	}
	
}