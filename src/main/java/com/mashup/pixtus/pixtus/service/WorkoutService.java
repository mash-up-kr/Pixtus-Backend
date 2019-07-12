package com.mashup.pixtus.pixtus.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mashup.pixtus.pixtus.dto.WorkoutHistoryRequest;
import com.mashup.pixtus.pixtus.dto.WorkoutHistoryResponse;
import com.mashup.pixtus.pixtus.dto.WorkoutRegisterResponse;
import com.mashup.pixtus.pixtus.dto.WorkoutRequest;
import com.mashup.pixtus.pixtus.entity.Exercise;
import com.mashup.pixtus.pixtus.entity.Workout;
import com.mashup.pixtus.pixtus.repository.WorkoutRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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
		System.out.println(date);

		return workoutRepository.findByUidAndDate(uid, date);
	}

	@Transactional
	public WorkoutRegisterResponse registerWorkout(WorkoutRequest requestBody) {
		String date = PixtusUtils.getTodayDate();
		Exercise exercise = exerciseService.get(requestBody.getExerciseId());

		Workout workout = get(date, requestBody, exercise);
		workoutRepository.save(workout);

		int kcal = PixtusUtils.calculateKcal(exercise.getKcal(), requestBody.getTime());
		workout.updateWorkout(requestBody.getTime(), kcal);

		userService.increaseExp(requestBody.getUid(), kcal);

		return new WorkoutRegisterResponse(kcal);
	}

	@Transactional
	public Workout get(String date, WorkoutRequest requestBody, Exercise exercise) {
		return workoutRepository.findByUidAndDateAndExerciseId(requestBody.getUid(), date, requestBody.getExerciseId())
				.orElseGet(() -> Workout.from(requestBody, date, exercise));
	}

	@Transactional
	public List<WorkoutHistoryResponse> getHistory(WorkoutHistoryRequest requestBody) {
		int prevWeek = requestBody.getPrevWeek();
		LocalDate startLocalDate = getStartDate(prevWeek);
		LocalDate endLocalDate = getEndDate(startLocalDate, prevWeek);

		String startDate = startLocalDate.format(DateTimeFormatter.BASIC_ISO_DATE);
		String endDate = endLocalDate.format(DateTimeFormatter.BASIC_ISO_DATE);

		List<Workout> list = workoutRepository.findByUidAndDateBetween(requestBody.getUid(), startDate, endDate);

		return list.stream().map(WorkoutHistoryResponse::new).collect(Collectors.toList());
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