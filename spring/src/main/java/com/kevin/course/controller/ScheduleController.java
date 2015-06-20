package com.kevin.course.controller;

import com.kevin.course.object.*;
import com.kevin.course.operation.business.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by loli on 2015/6/18.
 */
@Controller
public class ScheduleController {
    @Autowired
    private StudentBusinessOperation studentOperation;
    @Autowired
    private FirstCourseBusinessOperation firstCourseOperation;
    @Autowired
    private SecondCourseBusinessOperation secondCourseOperation;
    @Autowired
    private TeacherBusinessOperation teacherOperation;
    @Autowired
    private ScheduleBusinessOperation scheduleOperation;

    /* id indicate the studentId*/
    @RequestMapping(value = "schedule", method = RequestMethod.GET)
    public ModelAndView getAll(int id) {
        Student student = studentOperation.get(id);
        List<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(student.getGrade());
        List<Teacher> teacherList = teacherOperation.getAll();

        List<Schedule> scheduleList = scheduleOperation.getByStudentId(id);
        List<SecondCourse> scheduledSecondCourseList = new ArrayList<SecondCourse>();
        List<Teacher> scheduledTeacherList = new ArrayList<Teacher>();

        for(Schedule schedule : scheduleList){
            scheduledSecondCourseList.add(secondCourseOperation.get(schedule.getCourseId()));
            scheduledTeacherList.add(teacherOperation.get(schedule.getTeacherId()));
        }

        ModelAndView model = new ModelAndView("schedule");
        model.addObject("student", student);
        model.addObject("firstCourseList", firstCourseList);
        model.addObject("teacherList", teacherList);
        model.addObject("scheduleList", scheduleList);
        model.addObject("totalHours", calculateTotalHours(scheduleList));
        model.addObject("scheduledSecondCourseList", scheduledSecondCourseList);
        model.addObject("scheduledTeacherList", scheduledTeacherList);
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

    @ResponseBody
    @RequestMapping(value = "service/schedule/getSecondCourseList",  method =RequestMethod.GET )
    public List<SecondCourse> getSecondCourseList(int studentId, int firstCourseId){
        List<SecondCourse> secondCourseList = scheduleOperation.getSecondCourseList(studentId, firstCourseId);
        return secondCourseList;
    }

    @ResponseBody
    @RequestMapping(value = "service/schedule/getTeacherList",  method =RequestMethod.GET )
    public  List<Teacher> getTeacherListByGet(Date onDate, int onTime, int firstCourseId){
        List<Teacher> teacherList = scheduleOperation.getTeacherList(onDate, onTime, firstCourseId);
        return teacherList;
    }

    @ResponseBody
    @RequestMapping(value = "service/schedule/getAvailableTeacherList", method =RequestMethod.GET )
    public List<Teacher> getAvailableTeacherListByGet(Date onDate, int onTime){
        return scheduleOperation.getAvailableTeacherList(onDate, onTime);
    }

    @ResponseBody
    @RequestMapping(value = "service/schedule/getSecondCourseAndTeacherList", method =RequestMethod.GET )
    public Map<String, Object> getSecondCourseAndTeacherListByGet( Date onDate,  int onTime,
                                                                   int studentId, int firstCourseId){
        List<SecondCourse> secondCourseList = scheduleOperation.getSecondCourseList(studentId, firstCourseId);
        List<Teacher> teacherList = scheduleOperation.getTeacherList(onDate, onTime, firstCourseId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("secondCourseList", secondCourseList);
        map.put("teacherList", teacherList);
        return map;
    }
}
