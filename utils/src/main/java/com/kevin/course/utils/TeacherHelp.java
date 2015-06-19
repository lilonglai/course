package com.kevin.course.utils;

import com.kevin.course.object.Teacher;

public class TeacherHelp {
	public static String getTeacherName(Teacher teacher){
		String name = null;
		if(teacher != null)
			name = teacher.getName();
		return name;
	}

}
