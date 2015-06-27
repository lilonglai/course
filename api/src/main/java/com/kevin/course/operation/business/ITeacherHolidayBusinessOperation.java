package com.kevin.course.operation.business;

import com.kevin.course.object.TeacherHoliday;

import java.util.List;

public interface ITeacherHolidayBusinessOperation {

    public void add(TeacherHoliday teacherHoliday);

    public void update(TeacherHoliday teacherHoliday);

    public TeacherHoliday get(int id);

    public void delete(int id);

    public List<TeacherHoliday> getAll();

    public TeacherHoliday getByTeacherAndDate(int teacherId, String date);

    public List<TeacherHoliday> getByTeacherId(int teacherId);
}
