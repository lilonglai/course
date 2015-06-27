package com.kevin.course.operation.business;

import com.kevin.course.object.Student;

import java.util.List;

public interface IStudentBusinessOperation {
    public void add(Student student);

    public void update(Student student);

	public Student get(int id);

	public void delete(int id);

	public void retire(int id);

    public List<Student> getAll();

    public List<Student> getAlive();

    public List<Student> getNotAlive();
}
