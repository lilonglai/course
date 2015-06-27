package com.kevin.course.operation.business;

import com.kevin.course.object.SecondCourse;

import java.util.List;

public interface ISecondCourseBusinessOperation {

    public void add(SecondCourse secondCourse);

    public void update(SecondCourse secondCourse);

	public SecondCourse get(int secondCourseId);

	public void delete(int secondCourseId);

    public List<SecondCourse> getAll();

    public List<SecondCourse> getByGrade(int grade);
	
}
