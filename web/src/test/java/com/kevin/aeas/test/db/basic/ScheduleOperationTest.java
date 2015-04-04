package com.kevin.aeas.test.db.basic;

import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.operation.db.basic.JdbcScheduleOperation;
import com.kevin.aeas.operation.db.mybatis.MyBatisScheduleOperation;
import junit.framework.TestCase;

import java.sql.Date;
import java.util.List;

public class ScheduleOperationTest extends TestCase {
    public void  testGet(){
        JdbcScheduleOperation operation = new JdbcScheduleOperation();
        Schedule schedule = operation.get(1);
    }

    public void testGetByStudentIdOnDateAndTime(){
        JdbcScheduleOperation operation = new JdbcScheduleOperation();
        Schedule schedule = operation.getByStudentIdOnDateAndTime(1, new Date(1989, 07, 23), 1);
    }

    public void testGetByStudentId(){
        JdbcScheduleOperation operation = new JdbcScheduleOperation();
        List<Schedule> list = operation.getByStudentId(1);
    }

    public void testGetByTeacherId(){
        JdbcScheduleOperation operation = new JdbcScheduleOperation();
        List<Schedule> list = operation.getByTeacherId(1);
    }

    public void testGetByDateAndTime(){
        JdbcScheduleOperation operation = new JdbcScheduleOperation();
        List<Schedule> list = operation.getByDateAndTime(new Date(1989, 07, 23), 1);
    }

    public void testGetAll(){
        JdbcScheduleOperation operation = new JdbcScheduleOperation();
        List<Schedule> list = operation.getAll();
    }

    public void testAdd(){
        JdbcScheduleOperation operation = new JdbcScheduleOperation();

        Schedule schedule = new Schedule();
        schedule.setOnDate(new Date(1989, 07, 23));
        schedule.setOnTime(1);
        schedule.setStudentId(1);
        schedule.setCourseId(1);
        schedule.setTeacherId(1);
        operation.add(schedule);
    }

    public void testUpdate(){
        JdbcScheduleOperation operation = new JdbcScheduleOperation();
        Schedule schedule = new Schedule();
        schedule.setOnDate(new Date(1989, 07, 23));
        schedule.setOnTime(2);
        schedule.setStudentId(1);
        schedule.setCourseId(1);
        schedule.setTeacherId(1);
        operation.update(schedule);
    }

    public void testDelete(){
        JdbcScheduleOperation operation = new JdbcScheduleOperation();
        operation.delete(1);
    }

}
