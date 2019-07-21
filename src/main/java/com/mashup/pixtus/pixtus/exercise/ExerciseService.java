package com.mashup.pixtus.pixtus.exercise;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mashup.pixtus.pixtus.exercise.entity.Exercise;

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
