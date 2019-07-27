package com.mashup.pixtus.pixtus.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PixtusUtils {

	public static String getTodayDate() {
		return LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
	}

//   TODO 계산하는 부분 개선 필요
	public static int calculateKcal(int kcal, int time) {
		int min = time / 60;
		return kcal * min;
	}

	public static StartAndEndDate getDate (int prevWeek){
		LocalDate startLocalDate = getStartDate(prevWeek);
		LocalDate endLocalDate = getEndDate(startLocalDate, prevWeek);

		String startDate = startLocalDate.format(DateTimeFormatter.BASIC_ISO_DATE);
		String endDate = endLocalDate.format(DateTimeFormatter.BASIC_ISO_DATE);

		return StartAndEndDate
				.builder()
				.startDate(startDate)
				.endDate(endDate)
				.build();
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
