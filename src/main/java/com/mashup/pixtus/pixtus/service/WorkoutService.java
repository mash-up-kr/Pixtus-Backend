package com.mashup.pixtus.pixtus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mashup.pixtus.pixtus.entity.Workout;
import com.mashup.pixtus.pixtus.repository.WorkoutRepository;

@Service
public class WorkoutService {

	private WorkoutRepository workoutRepository;

	public WorkoutService(WorkoutRepository workoutRepository) {
		this.workoutRepository = workoutRepository;
	}

	public List<Workout> listToday(String uid) {
		String date = PixtusUtils.getTodayDate();

		return workoutRepository.findByUidAndDate(uid, date);
	}

}
