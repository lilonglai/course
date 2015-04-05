package com.kevin.aeas.operation.business;

import com.kevin.aeas.object.Student;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.StudentOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class StudentBusinessOperation {
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
