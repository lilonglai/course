package com.kevin.aeas.operation.db.mybatis.inter;

import com.kevin.aeas.object.Teacher;

import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface MyBatisTeacher {
    public Teacher get(int key);

    public Teacher getByName(String name);

    public Teacher getByShortName(String shortName);

    public List<Teacher> getAll();

    public List<Teacher> getAlive();

    public List<Teacher> getNotAlive();

    public Teacher getByCondition(Teacher condition);

    public void add(Teacher teacher);

    public void update(Teacher teacher);

    public void delete(int key);

    public void retire(int key);
}
