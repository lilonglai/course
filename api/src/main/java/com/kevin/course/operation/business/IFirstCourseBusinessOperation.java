package com.kevin.course.operation.business;

import com.kevin.course.object.FirstCourse;

import java.util.List;

public interface IFirstCourseBusinessOperation {

    public void add(FirstCourse firstCourse);

    public void update(FirstCourse firstCourse);

    public FirstCourse get(int firstCourseId);

    public void delete(int firstCourseId);

    public List<FirstCourse> getAll();

    public List<FirstCourse> getByGrade(int grade);

}
