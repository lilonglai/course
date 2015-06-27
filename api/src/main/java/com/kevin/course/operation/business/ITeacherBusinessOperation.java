package com.kevin.course.operation.business;

import com.kevin.course.object.Teacher;

import java.util.List;

public interface ITeacherBusinessOperation {
    public void add(Teacher teacher);

    public void update(Teacher teacher);

    public Teacher get(int teacherId);

    public void delete(int teacherId);

    public void retire(int teacherId);

    public List<Teacher> getAll();

    public List<Teacher> getAlive();

    public List<Teacher> getNotAlive();

}
