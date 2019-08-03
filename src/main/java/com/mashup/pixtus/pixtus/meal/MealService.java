package com.mashup.pixtus.pixtus.meal;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashup.pixtus.pixtus.jwt.JwtService;
import com.mashup.pixtus.pixtus.meal.dto.MealHistoryDto;
import com.mashup.pixtus.pixtus.meal.dto.ReqMealDto;
import com.mashup.pixtus.pixtus.meal.entity.Meal;
import com.mashup.pixtus.pixtus.meal.entity.MealType;
import com.mashup.pixtus.pixtus.user.service.UserService;
import com.mashup.pixtus.pixtus.util.PixtusUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MealService {

    private final UserService userService;
    private final MealRepository mealRepository;
    private final JwtService jwtService;

    public List<MealHistoryDto> getHistory(String uid, String startDate, String endDate) {
        return mealRepository.findByUidAndDateBetween(uid, startDate, endDate)
                             .stream()
                             .map(MealHistoryDto::new)
                             .collect(Collectors.toList());
    }

	@Transactional
	public void registerMeal(ReqMealDto requestBody) {
		String uid = jwtService.getUid();
		String dateId = PixtusUtils.getTodayDate();

		List<Meal> meals = mealRepository.findByUidAndDateId(uid, dateId);
		Map<MealType, Meal> mealTypeAndMeal = meals.stream()
				.collect(Collectors.toMap(Meal::getType, Function.identity()));

		MealType[] mealTypes = MealType.values();

		for (MealType mealType : mealTypes) {
			Meal meal = mealTypeAndMeal.get(mealType);
			boolean isSelected = requestBody.isSelected(mealType);

			if (meal == null && isSelected)
				addMeal(uid, dateId, mealType);
			else if (meal != null && !isSelected)
				deleteMeal(uid, meal);
		}
	}

	private void addMeal(String uid, String dateId, MealType mealType) {
		Meal meal = new Meal(uid, dateId, mealType, mealType.getKcal());
		mealRepository.save(meal);

		userService.decreaseExp(uid, mealType.getKcal());
	}

	private void deleteMeal(String uid, Meal meal) {
		mealRepository.delete(meal);

		userService.increaseExp(uid, meal.getType().getKcal());
	}
}
