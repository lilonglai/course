package com.kevin.aeas.operation.business;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.operation.db.FirstCourseOperation;
import com.kevin.aeas.operation.db.OperationManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class FirstCourseBusinessOperation {
    FirstCourseOperation firstCourseOperation = OperationManager.getInstance().getFirstCourseOperation();

    public void add(FirstCourse firstCourse){
        firstCourseOperation.add(firstCourse);
    }

    public void update(FirstCourse firstCourse){
        firstCourseOperation.update(firstCourse);
    }

	public FirstCourse get(int firstCourseId){
		return firstCourseOperation.get(firstCourseId);
	}

	public void delete(int firstCourseId){
        firstCourseOperation.delete(firstCourseId);
	}

    public List<FirstCourse> getAll(){
        return firstCourseOperation.getAll();
    }

    public List<FirstCourse> getByGrade(int grade){
        return firstCourseOperation.getByGrade(grade);
    }

}
