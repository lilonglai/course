package com.kevin.aeas.operation.db;

import com.kevin.aeas.object.TeacherHoliday;

import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface ITeacherHolidayOperation {
    public TeacherHoliday get(int key);

    public List<? extends TeacherHoliday> getByTeacherId(int teacherId);

    public TeacherHoliday getByTeacherAndDate( int teacherId, String date);

    public List<? extends TeacherHoliday> getAll();

    public void add(TeacherHoliday teacherHoliday);

    public void update(TeacherHoliday teacherHoliday);

    public void delete(int key);
}
