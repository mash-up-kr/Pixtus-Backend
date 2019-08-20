package com.mashup.pixtus.pixtus.workout.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashup.pixtus.pixtus.exercise.entity.Exercise;
import com.mashup.pixtus.pixtus.exercise.service.ExerciseService;
import com.mashup.pixtus.pixtus.jwt.JwtService;
import com.mashup.pixtus.pixtus.user.service.UserService;
import com.mashup.pixtus.pixtus.util.PixtusUtils;
import com.mashup.pixtus.pixtus.workout.WorkoutRepository;
import com.mashup.pixtus.pixtus.workout.dto.ReqWorkoutRegisterDto;
import com.mashup.pixtus.pixtus.workout.dto.ResWorkoutRegisterDto;
import com.mashup.pixtus.pixtus.workout.dto.WorkoutHistoryDto;
import com.mashup.pixtus.pixtus.workout.entity.Workout;

@Service
public class WorkoutService {

	private WorkoutRepository workoutRepository;
	private ExerciseService exerciseService;
	private UserService userService;
	private JwtService jwtService;

	public WorkoutService(WorkoutRepository workoutRepository, ExerciseService exerciseService, UserService userService,
			JwtService jwtService) {
		this.workoutRepository = workoutRepository;
		this.exerciseService = exerciseService;
		this.userService = userService;
		this.jwtService = jwtService;
	}

	public List<Workout> listToday(String uid) {
		String dateId = PixtusUtils.getTodayDateId();

		return workoutRepository.findByUidAndDateId(uid, dateId);
	}

	@Transactional
	public ResWorkoutRegisterDto registerWorkout(ReqWorkoutRegisterDto requestBody) {
		String uid = jwtService.getUid();

		String dateId = PixtusUtils.getTodayDateId();
		Exercise exercise = exerciseService.get(requestBody.getExerciseId());

		Workout workout = get(uid, dateId, exercise);

		int kcal = exercise.getCalcKcal(requestBody.getAmount());

		workout.updateWorkout(requestBody.getAmount(), kcal);
		workoutRepository.save(workout);

		userService.increaseExp(uid, kcal);

		return new ResWorkoutRegisterDto(kcal);
	}

	private Workout get(String uid, String dateId, Exercise exercise) {
		return workoutRepository.findByUidAndDateIdAndExerciseId(uid, dateId, exercise.getExerciseId())
				.orElseGet(() -> Workout.from(uid, dateId, exercise));
	}

	public List<WorkoutHistoryDto> getHistory(String uid, String startDateId, String endDateId) {
		return workoutRepository.findByUidAndDateIdBetween(uid, startDateId, endDateId).stream()
				.map(WorkoutHistoryDto::new).collect(Collectors.toList());
	}

}