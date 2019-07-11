package com.mashup.pixtus.pixtus.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PixtusUtils {

	public static String getTodayDate() {
		return LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
	}

//   TODO 계산하는 부분 개선 필요
	public static int calculateKcal(int kcal, int time){
		return kcal * time;
	}

}
