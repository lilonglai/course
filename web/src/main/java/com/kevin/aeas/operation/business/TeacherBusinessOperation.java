package com.kevin.aeas.operation.business;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.TeacherOperation;

import java.util.List;

public class TeacherBusinessOperation {
    TeacherOperation teacherOperation = OperationManager.getInstance().getTeacherOperation();

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
