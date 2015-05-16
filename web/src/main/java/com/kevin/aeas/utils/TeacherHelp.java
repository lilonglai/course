package com.kevin.aeas.utils;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.business.TeacherBusinessOperation;

public class TeacherHelp {
	public static String getTeacherName(TeacherBusinessOperation teacherOperation, int teacherId){
		Teacher teacher = teacherOperation.get(teacherId);
		String name = null;
		if(teacher != null)
			name = teacher.getName();
		return name;
	}

}
