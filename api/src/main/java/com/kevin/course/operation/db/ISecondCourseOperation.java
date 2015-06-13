package com.kevin.course.operation.db;

import com.kevin.course.object.SecondCourse;

import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface ISecondCourseOperation {
    public SecondCourse get(int key);

    public List<SecondCourse> getByFirstCourseId(int firstCourseId);

    public List<SecondCourse> getByGrade(int grade);

    public List<SecondCourse> getAll();

    public void add(SecondCourse secondCourse);

    public void update(SecondCourse secondCourse);

    public void delete(int key);
}
