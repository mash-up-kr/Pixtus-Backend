package com.mashup.pixtus.pixtus.workout.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mashup.pixtus.pixtus.exercise.entity.Exercise;
import com.mashup.pixtus.pixtus.exercise.service.ExerciseService;
import com.mashup.pixtus.pixtus.jwt.JwtService;
import com.mashup.pixtus.pixtus.user.service.UserService;
import com.mashup.pixtus.pixtus.workout.WorkoutRepository;
import com.mashup.pixtus.pixtus.workout.dto.ReqWorkoutRegisterDto;
import com.mashup.pixtus.pixtus.workout.entity.Workout;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkoutServiceTest {

	@Autowired
	private WorkoutService workoutService;

	@MockBean
	private WorkoutRepository workoutRepository;

	@MockBean
	private ExerciseService exerciseService;

	@MockBean
	private UserService userService;

	@MockBean
	private JwtService jwtService;

	private String uid;
	private int exerciseId;

	@Before
	public void setUp() {
		uid = "1234";
		exerciseId = 1;
	}

	@Test
	public void test_registerWorkout() {
		ReqWorkoutRegisterDto requestBody = new ReqWorkoutRegisterDto();
		requestBody.setExerciseId(1);
		requestBody.setAmount(100);

		Exercise exercise = mock(Exercise.class);
		given(exercise.getCalcKcal(100)).willReturn(33);

		given(jwtService.getUid()).willReturn(uid);
		given(exerciseService.get(exerciseId)).willReturn(exercise);

		workoutService.registerWorkout(requestBody);

		ArgumentCaptor<Workout> saveArg = ArgumentCaptor.forClass(Workout.class);
		verify(workoutRepository, times(1)).save(saveArg.capture());
		assertEquals(33, saveArg.getValue().getTotalKcal());
	}

}
