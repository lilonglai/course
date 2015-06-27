package com.kevin.course.operation.business;

import com.kevin.course.object.TeacherDefaultHoliday;

import java.util.List;

public interface ITeacherDefaultHolidayBusinessOperation {

    public void add(TeacherDefaultHoliday teacherDefaultHoliday);

    public void update(TeacherDefaultHoliday teacherDefaultHoliday);

    public TeacherDefaultHoliday get(int id);

    public void delete(int id);

    public List<TeacherDefaultHoliday> getAll();

    public TeacherDefaultHoliday getByTeacherId(int teacherId);

    public void deleteByTeacherId(int teacherId);
}
