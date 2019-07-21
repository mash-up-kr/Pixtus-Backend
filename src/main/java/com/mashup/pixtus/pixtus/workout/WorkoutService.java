package com.mashup.pixtus.pixtus.workout;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashup.pixtus.pixtus.exercise.ExerciseService;
import com.mashup.pixtus.pixtus.exercise.entity.Exercise;
import com.mashup.pixtus.pixtus.user.service.UserService;
import com.mashup.pixtus.pixtus.util.PixtusUtils;
import com.mashup.pixtus.pixtus.workout.dto.ResWorkoutHistoryDto;
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

	public List<ResWorkoutHistoryDto> getHistory(String uid, int prevWeek) {
		LocalDate startLocalDate = getStartDate(prevWeek);
		LocalDate endLocalDate = getEndDate(startLocalDate, prevWeek);

		String startDate = startLocalDate.format(DateTimeFormatter.BASIC_ISO_DATE);
		String endDate = endLocalDate.format(DateTimeFormatter.BASIC_ISO_DATE);
		
		List<Workout> list = workoutRepository.findByUidAndDateBetween(uid, startDate, endDate);

		return list.stream().map(ResWorkoutHistoryDto::new).collect(Collectors.toList());
	}

	private LocalDate getStartDate(int prevWeek) {
		LocalDate today = LocalDate.now();
		int todayValue = today.getDayOfWeek().getValue();

		return today.minusWeeks(prevWeek + 1).plusDays(7 - todayValue);
	}

	private LocalDate getEndDate(LocalDate startDate, int prevWeek) {
		if (prevWeek == 0)
			return LocalDate.now();

		return startDate.plusDays(6);
	}

}