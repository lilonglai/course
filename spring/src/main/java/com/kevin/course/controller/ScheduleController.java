package com.kevin.course.controller;

import com.kevin.course.object.*;
import com.kevin.course.operation.business.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by loli on 2015/6/18.
 */
@Controller
public class ScheduleController {
    private StudentBusinessOperation studentOperation;
    private FirstCourseBusinessOperation firstCourseOperation;
    private SecondCourseBusinessOperation secondCourseOperation;
    private TeacherBusinessOperation teacherOperation;
    private ScheduleBusinessOperation scheduleOperation;

    @RequestMapping(value = "schedule", method = RequestMethod.GET)
    public ModelAndView getAll(int studentId) {
        Student student = studentOperation.get(studentId);
        List<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(student.getGrade());
        List<Teacher> teacherList = teacherOperation.getAll();

        List<Schedule> scheduleList = scheduleOperation.getByStudentId(studentId);

        ModelAndView model = new ModelAndView("course");
        model.addObject("student", student);
        model.addObject("firstCourseList", firstCourseList);
        model.addObject("teacherList", teacherList);
        model.addObject("scheduleList", scheduleList);
        model.addObject("totalHours", calculateTotalHours(scheduleList));
        return model;
    }


    private double calculateTotalHours(List<Schedule> scheduleList){
        double totalHours = 0;
        for(Schedule schedule : scheduleList) {
            SecondCourse secondCourse = secondCourseOperation.get(schedule.getCourseId());
            Teacher teacher = teacherOperation.get(schedule.getTeacherId());
            if (schedule.getOnTime() == 1) {
                totalHours += 2.5;
            } else {
                totalHours += 2;
            }
        }
        return totalHours;
    }
}
