package com.kevin.aeas.operation.db.mybatis.inter;

import com.kevin.aeas.object.FirstCourse;

import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface MyBatisFirstCourse {
    public FirstCourse get(int key);

    public List<FirstCourse> getByGrade(int grade);

    public List<FirstCourse> getAll();

    public void add(FirstCourse firstCourse);

    public void update(FirstCourse firstCourse);

    public void delete(int key);
}
