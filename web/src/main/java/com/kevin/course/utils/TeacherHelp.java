package com.kevin.course.utils;

import com.kevin.course.object.Teacher;
import com.kevin.course.operation.business.TeacherBusinessOperation;

public class TeacherHelp {
	public static String getTeacherName(TeacherBusinessOperation teacherOperation, int teacherId){
		Teacher teacher = teacherOperation.get(teacherId);
		String name = null;
		if(teacher != null)
			name = teacher.getName();
		return name;
	}

}
