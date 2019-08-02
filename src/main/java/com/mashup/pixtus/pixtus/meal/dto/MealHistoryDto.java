package com.mashup.pixtus.pixtus.meal.dto;

import com.mashup.pixtus.pixtus.meal.entity.Meal;
import com.mashup.pixtus.pixtus.meal.entity.MealType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MealHistoryDto {
    private String date;

    private MealType type;

    private int kcal;

    public MealHistoryDto(Meal meal) {
        this.date = meal.getDate();
        this.type = meal.getType();
        this.kcal = meal.getTotalKcal();
    }

}
