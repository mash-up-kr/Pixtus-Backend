package com.mashup.pixtus.pixtus.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PixtusUtils {

	public static String getTodayDate() {
		return LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
	}

}
