package com.mashup.pixtus.pixtus.meal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mashup.pixtus.pixtus.meal.entity.Meal;
import com.mashup.pixtus.pixtus.meal.entity.MealType;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MealRepositoryTest {

	@Autowired
	private MealRepository mealRepository;

	private Meal meal1;
	private Meal meal2;
	private Meal meal3;

	private List<Meal> meals;

	private String uid;

	@Before
	public void setUp() {
		uid = "1234";

		meal1 = new Meal(uid, "20190810", MealType.L, MealType.L.getKcal());
		meal2 = new Meal(uid, "20190811", MealType.D, MealType.D.getKcal());
		meal3 = new Meal(uid, "20190812", MealType.M, MealType.M.getKcal());

		meals = new ArrayList<>();
		meals.add(meal1);
		meals.add(meal2);
		meals.add(meal3);
	}

	@Test
	public void test_save() {
		Meal saveMeal = mealRepository.save(meal1);

		assertThat(saveMeal.getUid()).isNotNull();
		assertThat(saveMeal.getUid()).isEqualTo(meal1.getUid());
	}

	@Test
	public void test_findByUidAndDateId() {
		mealRepository.saveAll(meals);

		List<Meal> findMeals = mealRepository.findByUidAndDateId(meal1.getUid(), meal1.getDateId());

		assertThat(findMeals.size()).isEqualTo(1);
		assertThat(findMeals.get(0).getDateId()).isEqualTo(meal1.getDateId());
	}

	@Test
	public void test_findByUidAndDateIdBetween() {
		mealRepository.saveAll(meals);

		List<Meal> findMeals = mealRepository.findByUidAndDateIdBetween(uid, meal1.getDateId(), meal2.getDateId());

		assertThat(findMeals.size()).isEqualTo(2);
		assertThat(findMeals.get(0).getDateId()).isEqualTo(meal1.getDateId());
		assertThat(findMeals.get(1).getDateId()).isEqualTo(meal2.getDateId());
	}

}
