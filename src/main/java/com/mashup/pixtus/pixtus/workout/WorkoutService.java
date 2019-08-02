package com.mashup.pixtus.pixtus.workout;

import java.util.List;
import java.util.stream.Collectors;

import com.mashup.pixtus.pixtus.meal.dto.MealHistoryDto;
import com.mashup.pixtus.pixtus.workout.dto.WorkoutHistoryDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashup.pixtus.pixtus.exercise.ExerciseService;
import com.mashup.pixtus.pixtus.exercise.entity.Exercise;
import com.mashup.pixtus.pixtus.user.service.UserService;
import com.mashup.pixtus.pixtus.util.PixtusUtils;
import com.mashup.pixtus.pixtus.workout.dto.ResWorkoutRegisterDto;
import com.mashup.pixtus.pixtus.workout.dto.ReqWorkoutRegisterDto;
import com.mashup.pixtus.pixtus.workout.entity.Workout;

@Service
public class WorkoutService {

	private WorkoutRepository workoutRepository;
	private ExerciseService exerciseService;
	private UserService userService;

	public WorkoutService(WorkoutRepository workoutRepository, ExerciseService exerciseService,
			UserService userService) {
		this.workoutRepository = workoutRepository;
		this.exerciseService = exerciseService;
		this.userService = userService;
	}

	public List<Workout> listToday(String uid) {
		String date = PixtusUtils.getTodayDate();

		return workoutRepository.findByUidAndDate(uid, date);
	}

	@Transactional
	public ResWorkoutRegisterDto registerWorkout(ReqWorkoutRegisterDto requestBody) {
		String date = PixtusUtils.getTodayDate();
		Exercise exercise = exerciseService.get(requestBody.getExerciseId());

		Workout workout = get(date, requestBody, exercise);
		workoutRepository.save(workout);

		int kcal = PixtusUtils.calculateKcal(exercise.getKcal(), requestBody.getTime());
		workout.updateWorkout(requestBody.getTime(), kcal);

		userService.increaseExp(requestBody.getUid(), kcal);

		return new ResWorkoutRegisterDto(kcal);
	}

	private Workout get(String date, ReqWorkoutRegisterDto requestBody, Exercise exercise) {
		return workoutRepository.findByUidAndDateAndExerciseId(requestBody.getUid(), date, requestBody.getExerciseId())
				.orElseGet(() -> Workout.from(requestBody, date, exercise));
	}


	public List<WorkoutHistoryDto> getHistory(String uid, String startDate, String endDate){
		return workoutRepository.findByUidAndDateBetween(uid, startDate, endDate)
				                .stream()
							    .map(WorkoutHistoryDto::new)
				                .collect(Collectors.toList());
	}

}