package com.kevin.course.operation.db;

import com.kevin.course.object.TeacherDefaultHoliday;

import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface ITeacherDefaultHolidayOperation {
    public TeacherDefaultHoliday get(int key);

    public TeacherDefaultHoliday getByTeacherId(int teacherId);

    public List<TeacherDefaultHoliday> getAll();

    public void add(TeacherDefaultHoliday teacherDefaultHoliday);

    public void update(TeacherDefaultHoliday teacherDefaultHoliday);

    public void delete(int key);

    public void deleteByTeacherId(int teacherId);
}
