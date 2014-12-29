package com.kevin.aeas.utils;

import com.kevin.aeas.object.v2.AeasTeacher;
import com.kevin.aeas.operation.v2.AeasTeacherOperation;

public class TeacherHelp {
	public static String getTeacherName(AeasTeacherOperation teacherOperation, int teacherId){
		AeasTeacher teacher = teacherOperation.get(teacherId);
		String name = null;
		if(teacher != null)
			name = teacher.getName();
		return name;
	}

}
