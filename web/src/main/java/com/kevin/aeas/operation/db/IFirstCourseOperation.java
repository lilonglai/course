package com.kevin.aeas.operation.db;

import com.kevin.aeas.object.FirstCourse;

import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface IFirstCourseOperation {
    public FirstCourse get(int key);

    public List<? extends FirstCourse> getByGrade(int grade);

    public List<? extends FirstCourse> getAll();

    public void add(FirstCourse firstCourse);

    public void update(FirstCourse firstCourse);

    public void delete(int key);
}
