package com.mashup.pixtus.pixtus.history;

import com.mashup.pixtus.pixtus.history.dto.ResHistoryDto;
import com.mashup.pixtus.pixtus.history.dto.MealHistoryDto;
import com.mashup.pixtus.pixtus.history.dto.WorkoutHistoryDto;
import com.mashup.pixtus.pixtus.meal.MealRepository;
import com.mashup.pixtus.pixtus.workout.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final MealRepository mealRepository;
    private final WorkoutRepository workoutRepository;


    public ResHistoryDto getHistory(String uid, int prevWeek) {

        LocalDate startLocalDate = getStartDate(prevWeek);
        LocalDate endLocalDate = getEndDate(startLocalDate, prevWeek);

        String startDate = startLocalDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String endDate = endLocalDate.format(DateTimeFormatter.BASIC_ISO_DATE);

        List<MealHistoryDto> mealHistoryList = mealRepository.findByUidAndDateBetween(uid, startDate, endDate)
                                                             .stream()
                                                             .map(MealHistoryDto::new)
                                                             .collect(Collectors.toList());

        List<WorkoutHistoryDto> workoutHistoryList = workoutRepository.findByUidAndDateBetween(uid, startDate, endDate)
                                                                      .stream()
                                                                      .map(WorkoutHistoryDto::new)
                                                                      .collect(Collectors.toList());

        return new ResHistoryDto(mealHistoryList, workoutHistoryList);
    }


    private static LocalDate getStartDate(int prevWeek) {
        LocalDate today = LocalDate.now();
        int todayValue = today.getDayOfWeek().getValue();

        return today.minusWeeks(prevWeek + 1).plusDays(7 - todayValue);
    }

    private static LocalDate getEndDate(LocalDate startDate, int prevWeek) {
        if (prevWeek == 0)
            return LocalDate.now();

        return startDate.plusDays(6);
    }

}
