package com.kevin.course.test.db.mybatis;

import com.kevin.course.object.Schedule;
import com.kevin.course.operation.db.mybatis.MyBatisScheduleOperation;
import junit.framework.TestCase;

import java.sql.Date;
import java.util.List;

public class ScheduleOperationTest  extends TestCase {
    public void  testGet(){
        MyBatisScheduleOperation operation = new MyBatisScheduleOperation();
        Schedule schedule = operation.get(1);
    }

    public void testGetByStudentIdOnDateAndTime(){
        MyBatisScheduleOperation operation = new MyBatisScheduleOperation();
        Schedule schedule = operation.getByStudentIdOnDateAndTime(1, new Date(1989, 07, 23), 1);
    }

    public void testGetByStudentId(){
        MyBatisScheduleOperation operation = new MyBatisScheduleOperation();
        List<Schedule> list = operation.getByStudentId(1);
    }

    public void testGetByTeacherId(){
        MyBatisScheduleOperation operation = new MyBatisScheduleOperation();
        List<Schedule> list = operation.getByTeacherId(1);
    }

    public void testGetByDateAndTime(){
        MyBatisScheduleOperation operation = new MyBatisScheduleOperation();
        List<Schedule> list = operation.getByDateAndTime(new Date(1989, 07, 23), 1);
    }

    public void testGetAll(){
        MyBatisScheduleOperation operation = new MyBatisScheduleOperation();
        List<Schedule> list = operation.getAll();
    }

    public void testAdd(){
        MyBatisScheduleOperation operation = new MyBatisScheduleOperation();
        Schedule schedule = new Schedule();
        schedule.setOnDate(new Date(1989, 07, 23));
        schedule.setOnTime(1);
        schedule.setStudentId(1);
        schedule.setCourseId(1);
        schedule.setTeacherId(1);
        operation.add(schedule);
    }

    public void testUpdate(){
        MyBatisScheduleOperation operation = new MyBatisScheduleOperation();
        Schedule schedule = new Schedule();
        schedule.setOnDate(new Date(1989, 07, 23));
        schedule.setOnTime(2);
        schedule.setStudentId(1);
        schedule.setCourseId(1);
        schedule.setTeacherId(1);
        operation.add(schedule);
    }

    public void testDelete(){
        MyBatisScheduleOperation operation = new MyBatisScheduleOperation();
        operation.delete(1);
    }

}
