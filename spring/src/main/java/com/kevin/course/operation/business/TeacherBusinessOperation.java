package com.kevin.course.operation.business;

import com.kevin.course.object.Teacher;
import com.kevin.course.operation.db.ITeacherOperation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherBusinessOperation {
    @Autowired
    private ITeacherOperation teacherOperation;

    public void add(Teacher teacher){
        teacherOperation.add(teacher);
    }


    public void update(Teacher teacher){
        teacherOperation.update(teacher);
    }


	public Teacher get(int teacherId){
		return teacherOperation.get(teacherId);
	}
	

	public void delete(int teacherId){
		teacherOperation.delete(teacherId);
	}

	public void retire(int teacherId){
		teacherOperation.retire(teacherId);
	}

    public List<Teacher> getAll(){
        return teacherOperation.getAll();
    }

    public List<Teacher> getAlive(){
        return teacherOperation.getAlive();
    }

    public List<Teacher> getNotAlive(){
        return teacherOperation.getNotAlive();
    }
	
}
