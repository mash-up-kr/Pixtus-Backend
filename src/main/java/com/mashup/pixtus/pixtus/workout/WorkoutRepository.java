package com.mashup.pixtus.pixtus.workout;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mashup.pixtus.pixtus.workout.entity.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

	List<Workout> findByUidAndDateId(String uid, String dateId);

	Optional<Workout> findByUidAndDateIdAndExerciseId(String uid, String dateId, int exerciseId);

	List<Workout> findByUidAndDateIdBetween(String uid, String startDateId, String endDateId);

}
