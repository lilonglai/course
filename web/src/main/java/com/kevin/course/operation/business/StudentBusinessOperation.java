package com.kevin.course.operation.business;

import com.kevin.course.object.Student;
import com.kevin.course.operation.db.OperationManager;
import com.kevin.course.operation.db.StudentOperation;

import java.util.List;

public class StudentBusinessOperation implements IStudentBusinessOperation{
    StudentOperation studentOperation = OperationManager.getInstance().getStudentOperation();

    public void add(Student student){
        studentOperation.add(student);
    }

    public void update(Student student){
        studentOperation.update(student);
    }

	public Student get(int id){
		return studentOperation.get(id);
	}

	public void delete(int id){
		studentOperation.delete(id);
	}

	public void retire(int id){
		studentOperation.retire(id);
	}

    public List<Student> getAll(){
        return studentOperation.getAll();
    }

    public List<Student> getAlive(){
        return studentOperation.getAlive();
    }

    public List<Student> getNotAlive(){
        return studentOperation.getNotAlive();
    }
}
