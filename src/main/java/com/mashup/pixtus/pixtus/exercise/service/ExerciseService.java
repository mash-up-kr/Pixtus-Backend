package com.mashup.pixtus.pixtus.exercise.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mashup.pixtus.pixtus.Exception.BadRequestException;
import org.springframework.stereotype.Service;

import com.mashup.pixtus.pixtus.exercise.ExerciseRepository;
import com.mashup.pixtus.pixtus.exercise.entity.Exercise;
import com.mashup.pixtus.pixtus.exercise.entity.ExerciseType;

@Service
public class ExerciseService {

	private ExerciseRepository exerciseRepository;

	public ExerciseService(ExerciseRepository exerciseRepository) {
		this.exerciseRepository = exerciseRepository;
	}

	public List<Exercise> getAll() {
		return exerciseRepository.findAll();
	}

	public List<Exercise> getExercisesByType(ExerciseType type) {
		return getAll().stream().filter(e -> e.getType() == type).collect(Collectors.toList());
	}

	public Exercise get(int id) {
		return exerciseRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("등록되지 않은 운동입니다."));
	}
}
