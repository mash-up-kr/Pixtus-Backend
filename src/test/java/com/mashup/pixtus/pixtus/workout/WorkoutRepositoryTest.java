package com.mashup.pixtus.pixtus.workout;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mashup.pixtus.pixtus.workout.entity.Workout;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkoutRepositoryTest  {
	
	@Autowired
	private WorkoutRepository workoutRepository;
	
	@Test
	public void test() {
		List<Workout> workOuts = workoutRepository.findAll();
		
		System.out.println(workOuts.size());
	}

}
