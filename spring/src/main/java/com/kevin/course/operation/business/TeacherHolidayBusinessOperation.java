package com.kevin.course.operation.business;

import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.operation.db.ITeacherHolidayOperation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherHolidayBusinessOperation implements ITeacherHolidayBusinessOperation {
    @Autowired
    private ITeacherHolidayOperation teacherHolidayOperation;

    public void add(TeacherHoliday teacherHoliday) {
        teacherHolidayOperation.add(teacherHoliday);
    }

    public void update(TeacherHoliday teacherHoliday) {
        teacherHolidayOperation.update(teacherHoliday);
    }

    public TeacherHoliday get(int id) {
        return teacherHolidayOperation.get(id);
    }

    public void delete(int id) {
        teacherHolidayOperation.delete(id);
    }

    public List<TeacherHoliday> getAll() {
        return teacherHolidayOperation.getAll();
    }

    public TeacherHoliday getByTeacherAndDate(int teacherId, String date) {
        return teacherHolidayOperation.getByTeacherAndDate(teacherId, date);
    }

    public List<TeacherHoliday> getByTeacherId(int teacherId) {
        return teacherHolidayOperation.getByTeacherId(teacherId);
    }
}
