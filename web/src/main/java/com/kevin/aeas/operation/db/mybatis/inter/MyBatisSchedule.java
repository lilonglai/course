package com.kevin.aeas.operation.db.mybatis.inter;

import com.kevin.aeas.object.Schedule;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface MyBatisSchedule {
    public Schedule get(int key);

    public Schedule getByStudentIdOnDateAndTime(@Param("studentId")int studentId, @Param("onDate")Date onDate, @Param("onTime")int onTime);

    public List<Schedule> getByStudentId(int studentId);

    public List<Schedule> getByTeacherId(int teacherId);

    public List<Schedule> getByDateAndTime(@Param("onDate")Date onDate, @Param("onTime")int onTime);

    public List<Schedule> getAll();

    public void add(Schedule schedule);

    public void update(Schedule schedule);

    public void delete(int key);
}
