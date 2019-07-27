package com.mashup.pixtus.pixtus.meal.dto;

import com.mashup.pixtus.pixtus.meal.entity.Meal;
import com.mashup.pixtus.pixtus.meal.entity.MealType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class ResMealHistoryDto {

    private String date;

    private MealType type;

    private int kcal;

    public ResMealHistoryDto(Meal meal) {
        this.date = meal.getDate();
        this.type = meal.getType();
        this.kcal = meal.getTotalKcal();
    }
}
