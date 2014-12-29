package com.kevin.aeas.utils;

public class GradeHelp {
	public static String getStringByNumber(int grade) {
		String result = null;
		switch (grade) {
		case 1:
			result = "4-6";
			break;
		case 2:
			result = "7-9";
			break;
		case 3:
			result = "10-12";
			break;
		}

		return result;
	}
	
	public static int getNumberByString(String gradeString) {
		int result = 0;
		switch (gradeString) {
		case "4-6":
			result = 1;
			break;
		case "7-9":
			result = 2;
			break;
		case "10-12":
			result = 3;
			break;
		}
		return result;
	}

}
