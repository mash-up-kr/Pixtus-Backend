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

	private static final int WALK_EXERCISE_ID = 1;

	public List<Exercise> getAll() {
		return exerciseRepository.findAll();
	}

	public List<Exercise> getAllExcludeId(int exerciseId) {
		return getAll().stream().filter(e -> e.getExerciseId() != exerciseId).collect(Collectors.toList());
	}

	public List<Exercise> getAllExcludeWalk() {
		return getAllExcludeId(WALK_EXERCISE_ID);
	}

	public Exercise get(int id) {
		return exerciseRepository.findById(id).get();
	}
}
