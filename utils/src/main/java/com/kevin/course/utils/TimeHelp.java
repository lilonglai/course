package com.kevin.course.utils;

public class TimeHelp {
	public static String getStringByNumber(int onTime) {
		String result = null;
		switch (onTime) {
		case 1:
			result = "9:00-11:30";
			break;
		case 2:
			result = "12:30-14:30";
			break;
		case 3:
			result = "14:45-16:45";
			break;
		default:
			result = "not correct";
			break;
		}

		return result;
	}
}
