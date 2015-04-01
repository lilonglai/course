package com.kevin.aeas.operation.db;

import com.kevin.aeas.object.Student;

import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface IStudentOperation {
    public Student get(int key);

    public Student getByName(String name);

    public List<? extends Student> getByGrade(int grade);

    public List<? extends Student> getAll();

    public List<? extends Student> getAlive();

    public List<? extends Student> getNotAlive();

    public List<? extends Student> getByTeacherId(int teacherId);

    public void add(Student student);

    public void update(Student student);

    public void delete(int key);

    public void retire(int key);
}
