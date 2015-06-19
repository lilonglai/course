package com.kevin.course.operation.business;

import com.kevin.course.object.SecondCourse;
import com.kevin.course.operation.db.ISecondCourseOperation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SecondCourseBusinessOperation {
    @Autowired
    ISecondCourseOperation secondCourseOperation;

    public void add(SecondCourse secondCourse){
        secondCourseOperation.add(secondCourse);
    }

    public void update(SecondCourse secondCourse){
        secondCourseOperation.update(secondCourse);
    }

	public SecondCourse get(int secondCourseId){
		return secondCourseOperation.get(secondCourseId);
	}

	public void delete(int secondCourseId){
		secondCourseOperation.delete(secondCourseId);
	}

    public List<SecondCourse> getAll(){
        return secondCourseOperation.getAll();
    }

    public List<SecondCourse> getByGrade(int grade){
        return secondCourseOperation.getByGrade(grade);
    }
	
}
