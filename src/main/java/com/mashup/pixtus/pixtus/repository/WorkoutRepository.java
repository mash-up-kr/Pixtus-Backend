package com.mashup.pixtus.pixtus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mashup.pixtus.pixtus.entity.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

	List<Workout> findByUidAndDate(String uid, String date);

	Optional<Workout> findByUidAndDateAndExerciseId(String uid, String date, int exerciseId);

	List<Workout> findByUidAndDateBetween(String uid, String startDate, String endDate);

}
