package com.kevin.course.operation.db;

import com.kevin.course.object.Student;

import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface IStudentOperation {
    public Student get(int key);

    public Student getByName(String name);

    public List<Student> getByGrade(int grade);

    public List<Student> getAll();

    public List<Student> getAlive();

    public List<Student> getNotAlive();

    public List<Student> getByTeacherId(int teacherId);

    public void add(Student student);

    public void update(Student student);

    public void delete(int key);

    public void retire(int key);
}
