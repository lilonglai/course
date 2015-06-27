package com.kevin.course.operation.business;

import com.kevin.course.object.Schedule;
import com.kevin.course.object.SecondCourse;
import com.kevin.course.object.Teacher;

import java.sql.Date;
import java.util.List;

/**
 * Created by loli on 2015/4/4.
 */
public interface IScheduleBusinessOperation {
    public void add(Schedule schedule);

    public void update(Schedule schedule);

    public Schedule get(int id);

    public void delete(int id);

    public List<Schedule> getAll();

    public List<Schedule> getByStudentId(int studentId);

    public List<SecondCourse> getSecondCourseList(int studentId, int firstCourseId);

    public List<Teacher> getTeacherList(Date onDate, int onTime, int firstCourseId);


    public List<Teacher> getAvailableTeacherList(Date onDate, int onTime);
}
