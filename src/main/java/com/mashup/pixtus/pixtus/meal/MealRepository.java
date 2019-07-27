package com.mashup.pixtus.pixtus.meal;

import com.mashup.pixtus.pixtus.meal.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository <Meal, Integer> {

    List<Meal> findByUidAndDateBetween(String uid, String startDate, String endDate);

}
