package com.kevin.aeas.operation.db;

import com.kevin.aeas.object.Teacher;

import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface ITeacherOperation {
    public Teacher get(int key);

    public Teacher getByName(String name);

    public Teacher getByShortName(String shortName);

    public List<? extends Teacher> getAll();

    public List<? extends Teacher> getAlive();

    public List<? extends Teacher> getNotAlive();

    public Teacher getByCondition(Teacher condition);

    public void add(Teacher teacher);

    public void update(Teacher teacher);

    public void delete(int key);

    public void retire(int key);
}
