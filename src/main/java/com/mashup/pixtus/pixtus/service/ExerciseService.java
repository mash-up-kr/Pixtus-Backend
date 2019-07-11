package com.mashup.pixtus.pixtus.service;

import com.mashup.pixtus.pixtus.entity.Exercise;
import com.mashup.pixtus.pixtus.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAll(){
        List<Exercise> exercises = exerciseRepository.findAll();
        return exercises;
    }

    public Exercise get(int id){
        return exerciseRepository.findById(id).get();
    }
}
