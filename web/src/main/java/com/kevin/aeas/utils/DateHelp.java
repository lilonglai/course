package com.kevin.aeas.utils;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.object.TeacherHoliday;

public class DateHelp {
	public static int getWeek(Calendar calendar) {
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		week = week - 1;
		if (week == 0)
			week = 7;
		return week;
	}

	public static int getDaysInMonth(Calendar calendar) {
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(calendar.getTime());
		localCalendar
				.set(Calendar.MONTH, localCalendar.get(Calendar.MONTH) + 1);
		localCalendar.set(Calendar.DAY_OF_MONTH, 1);
		localCalendar.set(Calendar.DATE, localCalendar.get(Calendar.DATE) - 1);
		return localCalendar.get(Calendar.DAY_OF_MONTH);
	}

	public static boolean isHoliday(Calendar calendar,
			TeacherDefaultHoliday teacherDefaultHoliday,List<TeacherHoliday> holidayList) {
		int week = getWeek(calendar);
		boolean flag = false;
		switch (week) {
		case 1:
			flag = teacherDefaultHoliday.getWeek1();
			break;
		case 2:
			flag = teacherDefaultHoliday.getWeek2();
			break;

		case 3:
			flag = teacherDefaultHoliday.getWeek3();
			break;

		case 4:
			flag = teacherDefaultHoliday.getWeek4();
			break;
		case 5:
			flag = teacherDefaultHoliday.getWeek5();
			break;
		case 6:
			flag = teacherDefaultHoliday.getWeek6();
			break;
		case 7:
			flag = teacherDefaultHoliday.getWeek7();
			break;

		default:
			throw new IllegalArgumentException("calendar has problems");

		}
		
		for(TeacherHoliday teacherHoliday:holidayList){
			Date date = new Date(calendar.getTime().getTime()); 
			if(teacherHoliday.getAdjustDate().toString().equals(date.toString())){
				flag = teacherHoliday.getIsHoliday();
				break;
			}
		}
		return flag;

	}
}
