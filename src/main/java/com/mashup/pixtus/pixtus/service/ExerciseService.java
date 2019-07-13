package com.mashup.pixtus.pixtus.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mashup.pixtus.pixtus.dto.ExerciseResponse;
import org.springframework.stereotype.Service;

import com.mashup.pixtus.pixtus.entity.Exercise;
import com.mashup.pixtus.pixtus.repository.ExerciseRepository;

@Service
public class ExerciseService {

	private ExerciseRepository exerciseRepository;

	public ExerciseService(ExerciseRepository exerciseRepository) {
		this.exerciseRepository = exerciseRepository;
	}

	public List<Exercise> getAll() {
		List<Exercise> exercises = exerciseRepository.findAll();

		exercises.stream().filter(e -> e.getExerciseId() != 1).collect(Collectors.toList());

		return exercises;
	}

	public Exercise get(int id) {
		return exerciseRepository.findById(id).get();
	}
}
