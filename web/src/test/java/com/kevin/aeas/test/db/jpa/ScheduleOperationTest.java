package com.kevin.aeas.test.db.jpa;

import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.operation.db.jpa.JpaScheduleOperation;
import com.kevin.aeas.operation.db.mybatis.MyBatisScheduleOperation;
import junit.framework.TestCase;

import java.sql.Date;
import java.util.List;

public class ScheduleOperationTest extends TestCase {
    public void  testGet(){
        JpaScheduleOperation operation = new JpaScheduleOperation();
        Schedule schedule = operation.get(1);
    }

    public void testGetByStudentIdOnDateAndTime(){
        JpaScheduleOperation operation = new JpaScheduleOperation();
        Schedule schedule = operation.getByStudentIdOnDateAndTime(1, new Date(1989, 07, 23), 1);
    }

    public void testGetByStudentId(){
        JpaScheduleOperation operation = new JpaScheduleOperation();
        List<Schedule> list = operation.getByStudentId(1);
    }

    public void testGetByTeacherId(){
        JpaScheduleOperation operation = new JpaScheduleOperation();
        List<Schedule> list = operation.getByTeacherId(1);
    }

    public void testGetByDateAndTime(){
        JpaScheduleOperation operation = new JpaScheduleOperation();
        List<Schedule> list = operation.getByDateAndTime(new Date(1989, 07, 23), 1);
    }

    public void testGetAll(){
        JpaScheduleOperation operation = new JpaScheduleOperation();
        List<Schedule> list = operation.getAll();
    }

    public void testAdd(){
        JpaScheduleOperation operation = new JpaScheduleOperation();
        Schedule schedule = new Schedule();
        schedule.setOnDate(new Date(1989, 07, 23));
        schedule.setOnTime(1);
        schedule.setStudentId(1);
        schedule.setCourseId(1);
        schedule.setTeacherId(1);
        operation.add(schedule);
    }

    public void testUpdate(){
        JpaScheduleOperation operation = new JpaScheduleOperation();
        Schedule schedule = new Schedule();
        schedule.setOnDate(new Date(1989, 07, 23));
        schedule.setOnTime(2);
        schedule.setStudentId(1);
        schedule.setCourseId(1);
        schedule.setTeacherId(1);
        operation.add(schedule);
    }

    public void testDelete(){
        JpaScheduleOperation operation = new JpaScheduleOperation();
        operation.delete(1);
    }

}
