package com.mashup.pixtus.pixtus.workout;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashup.pixtus.pixtus.exercise.ExerciseService;
import com.mashup.pixtus.pixtus.exercise.entity.Exercise;
import com.mashup.pixtus.pixtus.jwt.JwtService;
import com.mashup.pixtus.pixtus.user.service.UserService;
import com.mashup.pixtus.pixtus.util.PixtusUtils;
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
		String date = PixtusUtils.getTodayDate();

		return workoutRepository.findByUidAndDate(uid, date);
	}

	@Transactional
	public ResWorkoutRegisterDto registerWorkout(ReqWorkoutRegisterDto requestBody) {
		String uid = jwtService.getUid();

		String date = PixtusUtils.getTodayDate();
		Exercise exercise = exerciseService.get(requestBody.getExerciseId());

		Workout workout = get(uid, date, exercise);

		int kcal = PixtusUtils.calculateKcal(exercise.getKcal(), requestBody.getTime());
		workout.updateWorkout(requestBody.getTime(), kcal);
		workoutRepository.save(workout);

		userService.increaseExp(uid, kcal);

		return new ResWorkoutRegisterDto(kcal);
	}

	private Workout get(String uid, String date, Exercise exercise) {
		return workoutRepository.findByUidAndDateAndExerciseId(uid, date, exercise.getExerciseId())
				.orElseGet(() -> Workout.from(uid, date, exercise));
	}

	public List<WorkoutHistoryDto> getHistory(String uid, String startDate, String endDate) {
		return workoutRepository.findByUidAndDateBetween(uid, startDate, endDate).stream().map(WorkoutHistoryDto::new)
				.collect(Collectors.toList());
	}

}