package com.kevin.aeas.operation.db;

import com.kevin.aeas.object.SecondCourse;

import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface ISecondCourseOperation {
    public SecondCourse get(int key);

    public List<? extends SecondCourse> getByFirstCourseId(int firstCourseId);

    public List<? extends SecondCourse> getByGrade(int grade);

    public List<? extends SecondCourse> getAll();

    public void add(SecondCourse secondCourse);

    public void update(SecondCourse secondCourse);

    public void delete(int key);
}
