package com.kevin.course.controller;

import com.kevin.course.object.Teacher;
import com.kevin.course.object.TeacherDefaultHoliday;
import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.operation.business.TeacherBusinessOperation;
import com.kevin.course.operation.business.TeacherDefaultHolidayBusinessOperation;
import com.kevin.course.operation.business.TeacherHolidayBusinessOperation;
import com.kevin.course.utils.DateHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by loli on 2015/6/18.
 */
@Controller
public class TeacherHolidayController {
    @Autowired
    TeacherBusinessOperation teacherOperation;
    @Autowired
    TeacherDefaultHolidayBusinessOperation teacherDefaultHolidayOperation;
    @Autowired
    TeacherHolidayBusinessOperation teacherHolidayOperation;

    @RequestMapping( value = "teacherHoliday", method = RequestMethod.GET)
    public ModelAndView teacherHoliday(int teacherId){
        Teacher teacher = teacherOperation.get(teacherId);
        TeacherDefaultHoliday teacherDefaultHoliday = teacherDefaultHolidayOperation.getByTeacherId(teacherId);
        List<TeacherHoliday> holidayList = teacherHolidayOperation.getByTeacherId(teacherId);

        Calendar calendar = Calendar.getInstance();
        Calendar lastCalendar = (Calendar) calendar.clone();
        lastCalendar.add(Calendar.MONTH, -1);
        Calendar thisCalendar = (Calendar) calendar.clone();
        Calendar nextCalendar = (Calendar) calendar.clone();
        nextCalendar.add(Calendar.MONTH, -1);

        ModelAndView model = new ModelAndView("teacher");
        model.addObject("teacher", teacher);
        model.addObject("lastCalendar", lastCalendar);
        model.addObject("thisCalendar", thisCalendar);
        model.addObject("nextCalendar", nextCalendar);
        model.addObject("lastMonthHoliday", getLastMonthHoliday(calendar, teacherDefaultHoliday, holidayList));
        model.addObject("thisMonthHoliday", getThisMonthHoliday(calendar, teacherDefaultHoliday, holidayList));
        model.addObject("nextMonthHoliday", getNextMonthHoliday(calendar, teacherDefaultHoliday, holidayList));
        return model;
    }

    @RequestMapping( value = "teacherHolidayUpdate", method = RequestMethod.GET)
    public ModelAndView teacherHolidayUpdate(int teacherId, String control_date, boolean setHoliday){
        TeacherHoliday teacherHoliday = teacherHolidayOperation.getByTeacherAndDate(teacherId, control_date);
        if(teacherHoliday == null){
            teacherHoliday = new TeacherHoliday();
            teacherHoliday.setTeacherId(teacherId);
            teacherHoliday.setAdjustDate(Date.valueOf(control_date));
            teacherHoliday.setIsHoliday(setHoliday);
            teacherHolidayOperation.add(teacherHoliday);
        }else{
            teacherHoliday.setIsHoliday(setHoliday);
            teacherHolidayOperation.update(teacherHoliday);
        }

        return teacherHoliday(teacherId);
    }

    private String getMonthHoliday(Calendar calendar, TeacherDefaultHoliday teacherDefaultHoliday, List<TeacherHoliday> holidayList){
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        StringBuilder stringBuilder = new StringBuilder();
        int i=1;
        int days = DateHelp.getDaysInMonth(calendar);
        int week = DateHelp.getWeek(calendar);
        for(i =1; i< week; i++){
            if(i==1)
                stringBuilder.append("<tr>\r\n");
            stringBuilder.append("<td></td>\r\n");
        }

        for(i=1; i <= days; i++){
            week = DateHelp.getWeek(calendar);
            if(week % 7 == 1)
                stringBuilder.append("<tr>\r\n");
            if(DateHelp.isHoliday(calendar, teacherDefaultHoliday, holidayList)){
                stringBuilder.append("<td>" + i + "ÐÝÏ¢" + "</td>");
            }
            else{
                stringBuilder.append("<td>" + i + "</td>");
            }

            if(week % 7 ==0)
                stringBuilder.append("</tr>\r\n");


            calendar.add(Calendar.DAY_OF_MONTH, 1);

        }

        for(; week <7 ;week++){
            stringBuilder.append("<td></td>\r\n");
            if(week+1 == 7)
                stringBuilder.append("</tr>\r\n");
        }

        return stringBuilder.toString();
    }

    private String getLastMonthHoliday(Calendar calendar, TeacherDefaultHoliday teacherDefaultHoliday, List<TeacherHoliday> holidayList){
        Calendar changeCalendar = (Calendar) calendar.clone();
        calendar.add(Calendar.MONTH, -1);
        return getMonthHoliday(changeCalendar, teacherDefaultHoliday, holidayList);
    }

    private String getThisMonthHoliday(Calendar calendar, TeacherDefaultHoliday teacherDefaultHoliday, List<TeacherHoliday> holidayList){
        Calendar changeCalendar = (Calendar) calendar.clone();
        return getMonthHoliday(changeCalendar, teacherDefaultHoliday, holidayList);
    }

    private String getNextMonthHoliday(Calendar calendar, TeacherDefaultHoliday teacherDefaultHoliday, List<TeacherHoliday> holidayList){
        Calendar changeCalendar = (Calendar) calendar.clone();
        calendar.add(Calendar.MONTH, -1);
        return getMonthHoliday(changeCalendar, teacherDefaultHoliday, holidayList);
    }
}
