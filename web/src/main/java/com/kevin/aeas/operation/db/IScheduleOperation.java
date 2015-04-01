package com.kevin.aeas.operation.db;

import com.kevin.aeas.object.Schedule;

import java.sql.Date;
import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface IScheduleOperation {
    public Schedule get(int key);

    public Schedule getByStudentIdOnDateAndTime(int studentId, Date onDate, int onTime);

    public List<? extends Schedule> getByStudentId(int studentId);

    public List<? extends Schedule> getByTeacherId(int teacherId);

    public List<? extends Schedule> getByDateAndTime(Date onDate, int onTime);

    public List<? extends Schedule> getAll();

    public void add(Schedule schedule);

    public void update(Schedule schedule);

    public void delete(int key);
}
