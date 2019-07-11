package com.mashup.pixtus.pixtus.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Supplier;

import com.mashup.pixtus.pixtus.dto.WorkoutHistoryRequest;
import com.mashup.pixtus.pixtus.dto.WorkoutHistoryResponse;
import com.mashup.pixtus.pixtus.dto.WorkoutRegisterResponse;
import com.mashup.pixtus.pixtus.dto.WorkoutRequest;
import com.mashup.pixtus.pixtus.entity.Exercise;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import com.mashup.pixtus.pixtus.entity.Workout;
import com.mashup.pixtus.pixtus.repository.WorkoutRepository;
import org.springframework.web.bind.annotation.RequestBody;
import sun.misc.Request;

@Service
public class WorkoutService {

	private WorkoutRepository workoutRepository;
	private ExerciseService exerciseService;
	private UserService userService;

	public WorkoutService(WorkoutRepository workoutRepository, ExerciseService exerciseService, UserService userService) {
		this.workoutRepository = workoutRepository;
		this.exerciseService = exerciseService;
		this.userService = userService;
	}

	public List<Workout> listToday(String uid) {
		String date = PixtusUtils.getTodayDate();

		return workoutRepository.findByUidAndDate(uid, date);
	}

	public WorkoutRegisterResponse registerWorkout(WorkoutRequest requestBody){
		String date = PixtusUtils.getTodayDate();
		Exercise exercise = exerciseService.get(requestBody.getExerciseId());

		Workout workout = get(date, requestBody, exercise);

		int kcal = PixtusUtils.calculateKcal(exercise.getKcal(), requestBody.getTime());

		workout.updateWorkout(requestBody.getTime(), kcal);

		userService.increaseExp(requestBody.getUid() ,kcal);

		return new WorkoutRegisterResponse(kcal);
	}

	public Workout get(String date, WorkoutRequest requestBody, Exercise exercise){
		return workoutRepository.findByUidDateAndExerciseId(requestBody.getUid(), date, requestBody.getExerciseId())
				.orElseGet(() -> Workout.from(requestBody, date, exercise));
	}

	public WorkoutHistoryResponse getHistory(WorkoutHistoryRequest requestBody){
		int prevWeek = requestBody.getPrevWeek();
		LocalDate startDate = getStartDate(prevWeek);
		LocalDate endDate = getEndDate(startDate, prevWeek);

		return null;
	}

	private LocalDate getStartDate(int prevWeek) {
		LocalDate today = LocalDate.now();
		int todayValue = today.getDayOfWeek().getValue();

		return today.minusWeeks(prevWeek + 1).plusDays(7 - todayValue);
	}

	private LocalDate getEndDate(LocalDate startDate, int prevWeek) {
		if(prevWeek == 0)
			return LocalDate.now();

		return startDate.plusDays(6);
	}

}