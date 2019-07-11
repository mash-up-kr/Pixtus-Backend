package com.mashup.pixtus.pixtus.repository;

import java.util.List;
import java.util.Optional;

import com.mashup.pixtus.pixtus.dto.WorkoutRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mashup.pixtus.pixtus.entity.Workout;

import javax.swing.text.html.Option;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

	List<Workout> findByUidAndDate(String uid, String date);

	Optional<Workout> findByUidDateAndExerciseId(String uid, String date, int exerciseId);

	List<Workout> findByIdAndDateBetween(String uid, String startDate, String endDate);

}
