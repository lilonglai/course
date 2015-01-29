package com.kevin.aeas.utils;

import com.kevin.aeas.object.oracle.OracleTeacher;
import com.kevin.aeas.operation.jpa.JpaTeacherOperation;

public class TeacherHelp {
	public static String getTeacherName(JpaTeacherOperation teacherOperation, int teacherId){
		OracleTeacher teacher = teacherOperation.get(teacherId);
		String name = null;
		if(teacher != null)
			name = teacher.getName();
		return name;
	}

}
