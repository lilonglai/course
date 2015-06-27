package com.kevin.course.operation.business;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.operation.db.FirstCourseOperation;
import com.kevin.course.operation.db.OperationManager;

import java.util.List;

public class FirstCourseBusinessOperation implements IFirstCourseBusinessOperation{
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
