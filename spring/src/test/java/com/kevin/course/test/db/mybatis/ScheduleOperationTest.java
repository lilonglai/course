package com.kevin.course.test.db.mybatis;

import com.kevin.course.object.Schedule;
import com.kevin.course.operation.db.IScheduleOperation;
import com.kevin.course.test.db.utils.ApplicationContextUtils;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.util.List;

public class ScheduleOperationTest  extends TestCase {
    IScheduleOperation operation;
    public ScheduleOperationTest(){
        ApplicationContext context = ApplicationContextUtils.getMybatisInstance();
        operation = (IScheduleOperation)context.getBean("myBatisScheduleDao");
    }
    public void  testGet(){
        Schedule schedule = operation.get(1);
    }

    public void testGetByStudentIdOnDateAndTime(){
        Schedule schedule = operation.getByStudentIdOnDateAndTime(1, new Date(1989, 07, 23), 1);
    }

    public void testGetByStudentId(){
        List<Schedule> list = operation.getByStudentId(1);
    }

    public void testGetByTeacherId(){
        List<Schedule> list = operation.getByTeacherId(1);
    }

    public void testGetByDateAndTime(){
        List<Schedule> list = operation.getByDateAndTime(new Date(1989, 07, 23), 1);
    }

    public void testGetAll(){
        List<Schedule> list = operation.getAll();
    }

    public void testAdd(){
        Schedule schedule = new Schedule();
        schedule.setOnDate(new Date(1989, 07, 23));
        schedule.setOnTime(1);
        schedule.setStudentId(1);
        schedule.setCourseId(1);
        schedule.setTeacherId(1);
        operation.add(schedule);
    }

    public void testUpdate(){
        Schedule schedule = new Schedule();
        schedule.setOnDate(new Date(1989, 07, 23));
        schedule.setOnTime(2);
        schedule.setStudentId(1);
        schedule.setCourseId(1);
        schedule.setTeacherId(1);
        operation.add(schedule);
    }

    public void testDelete(){
        operation.delete(1);
    }

}
