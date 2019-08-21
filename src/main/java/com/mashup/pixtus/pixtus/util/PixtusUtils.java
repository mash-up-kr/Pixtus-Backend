package com.mashup.pixtus.pixtus.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PixtusUtils {

	public static String getTodayDateId() {
		return LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
	}

}
