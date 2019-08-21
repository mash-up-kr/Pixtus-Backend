package com.mashup.pixtus.pixtus.meal;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mashup.pixtus.pixtus.jwt.JwtService;
import com.mashup.pixtus.pixtus.meal.dto.ReqMealDto;
import com.mashup.pixtus.pixtus.meal.entity.Meal;
import com.mashup.pixtus.pixtus.meal.entity.MealType;
import com.mashup.pixtus.pixtus.user.service.UserService;
import com.mashup.pixtus.pixtus.util.PixtusUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MealServiceTest {

	@Autowired
	private MealService mealService;

	@MockBean
	private UserService userService;

	@MockBean
	private MealRepository mealRepository;

	@MockBean
	private JwtService jwtService;

	private String uid;
	private String dateId;

	private List<Meal> meals;

	@Before
	public void setUp() {
		uid = "1234";
		dateId = PixtusUtils.getTodayDateId();

		meals = new ArrayList<>();
		meals.add(new Meal(uid, dateId, MealType.B, MealType.B.getKcal()));
		meals.add(new Meal(uid, dateId, MealType.D, MealType.D.getKcal()));
	}

	@Test
	public void test_registerMeal() {
		given(jwtService.getUid()).willReturn(uid);
		given(mealRepository.findByUidAndDateId(uid, dateId)).willReturn(meals);

		ReqMealDto requestBody = new ReqMealDto();
		requestBody.setSelectedB(true); // 존재o + 선택o -> 변화x
		requestBody.setSelectedL(true); // 존재o + 선택x -> 추가
		requestBody.setSelectedD(false); // 존재x + 선택o -> 삭제
		requestBody.setSelectedM(false); // 존재x + 선택x -> 변화x

		mealService.registerMeal(requestBody);

		ArgumentCaptor<Meal> saveArg = ArgumentCaptor.forClass(Meal.class);
		verify(mealRepository, times(1)).save(saveArg.capture());
		assertEquals(MealType.L, saveArg.getValue().getType());

		ArgumentCaptor<Meal> deleteArg = ArgumentCaptor.forClass(Meal.class);
		verify(mealRepository, times(1)).delete(deleteArg.capture());
		assertEquals(MealType.D, deleteArg.getValue().getType());
	}

}
