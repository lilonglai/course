package com.kevin.course.test.db.basic;

import com.kevin.course.object.Schedule;
import com.kevin.course.object.Student;
import com.kevin.course.object.Teacher;
import com.kevin.course.operation.db.IScheduleOperation;
import com.kevin.course.operation.db.IStudentOperation;
import com.kevin.course.operation.db.ITeacherOperation;
import com.kevin.course.test.db.utils.ApplicationContextUtils;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.util.List;

public class ScheduleOperationTest extends TestCase {
    Teacher teacher;
    Student student;

    IScheduleOperation operation;
    public ScheduleOperationTest(){
        ApplicationContext context = ApplicationContextUtils.getJdbcInstance();
        operation = (IScheduleOperation)context.getBean("jdbcScheduleDao");
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
        schedule.setStudentId(student.getId());
        schedule.setCourseId(1);
        schedule.setTeacherId(teacher.getId());
        operation.add(schedule);
    }

    public void testUpdate(){
        Schedule schedule = new Schedule();
        schedule.setOnDate(new Date(1989, 07, 23));
        schedule.setOnTime(2);
        schedule.setStudentId(student.getId());
        schedule.setCourseId(1);
        schedule.setTeacherId(teacher.getId());
        operation.update(schedule);
    }

    public void testDelete(){
        operation.delete(1);
    }

    protected  void setUp(){
        ApplicationContext context = ApplicationContextUtils.getJdbcInstance();

        ITeacherOperation teacherOperation = (ITeacherOperation) context.getBean("jdbcTeacherDao");
        teacher = new Teacher();
        teacher.setName("test");
        teacher.setShortName("test");
        teacher.setIsMaster(true);
        teacher.setPhone("123456789");
        teacherOperation.add(teacher);

        IStudentOperation studentOperation = (IStudentOperation) context.getBean("jdbcStudentDao");
        student = new Student();
        student.setName("test");
        student.setShortName("test");
        student.setGrade(1);
        student.setTestScore("25");
        student.setTargetScore("50");
        student.setTeacherId(1);
        student.setExaminePlace("SH");
        student.setExamineDate(new Date(1985,6,20));
        student.setDescription("this is the test case for student");
        studentOperation.add(student);
    }

    protected void tearDown(){
        ApplicationContext context = ApplicationContextUtils.getJdbcInstance();
        ITeacherOperation teacherOperation = (ITeacherOperation) context.getBean("jdbcTeacherDao");
        teacherOperation.delete(teacher.getId());
        IStudentOperation studentOperation = (IStudentOperation) context.getBean("jdbcStudentDao");
        studentOperation.delete(student.getId());
    }

}
