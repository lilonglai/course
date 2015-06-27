package com.kevin.course.action;

import com.kevin.course.object.Teacher;
import com.kevin.course.object.TeacherDefaultHoliday;
import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.operation.business.*;
import com.kevin.course.utils.DateHelp;
import com.kevin.course.utils.HttpRequestUtil;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by loli on 2015/6/18.
 */
@Results({
        @Result(name = "teacherHoliday", location = "/teacherHoliday.jsp")})
public class TeacherHolidayAction {

    ITeacherBusinessOperation teacherOperation = new TeacherBusinessOperation();
    ITeacherDefaultHolidayBusinessOperation teacherDefaultHolidayOperation = new TeacherDefaultHolidayBusinessOperation();
    ITeacherHolidayBusinessOperation teacherHolidayOperation = new TeacherHolidayBusinessOperation();

    @Action("teacherHoliday")
    public String teacherHoliday() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Integer teacherId = HttpRequestUtil.getInt(request, "id");
        Teacher teacher = teacherOperation.get(teacherId);
        TeacherDefaultHoliday teacherDefaultHoliday = teacherDefaultHolidayOperation.getByTeacherId(teacherId);
        List<TeacherHoliday> holidayList = teacherHolidayOperation.getByTeacherId(teacherId);

        Calendar calendar = Calendar.getInstance();
        Calendar lastCalendar = (Calendar) calendar.clone();
        lastCalendar.add(Calendar.MONTH, -1);
        Calendar thisCalendar = (Calendar) calendar.clone();
        Calendar nextCalendar = (Calendar) calendar.clone();
        nextCalendar.add(Calendar.MONTH, -1);

        request.setAttribute("teacher", teacher);
        request.setAttribute("lastCalendar", lastCalendar);
        request.setAttribute("thisCalendar", thisCalendar);
        request.setAttribute("nextCalendar", nextCalendar);
        request.setAttribute("lastMonthHoliday", getLastMonthHoliday(calendar, teacherDefaultHoliday, holidayList));
        request.setAttribute("thisMonthHoliday", getThisMonthHoliday(calendar, teacherDefaultHoliday, holidayList));
        request.setAttribute("nextMonthHoliday", getNextMonthHoliday(calendar, teacherDefaultHoliday, holidayList));
        return "teacherHoliday";
    }

    @Action("teacherHolidayUpdate")
    public String teacherHolidayUpdate() throws UnsupportedEncodingException {
        HttpServletRequest request = ServletActionContext.getRequest();
        int teacherId = HttpRequestUtil.getInt(request, "teacherId");
        String control_date = HttpRequestUtil.getString(request, "control_date");
        boolean setHoliday = HttpRequestUtil.getBoolean(request, "setHoliday");
        TeacherHoliday teacherHoliday = teacherHolidayOperation.getByTeacherAndDate(teacherId, control_date);
        if (teacherHoliday == null) {
            teacherHoliday = new TeacherHoliday();
            teacherHoliday.setTeacherId(teacherId);
            teacherHoliday.setAdjustDate(Date.valueOf(control_date));
            teacherHoliday.setIsHoliday(setHoliday);
            teacherHolidayOperation.add(teacherHoliday);
        } else {
            teacherHoliday.setIsHoliday(setHoliday);
            teacherHolidayOperation.update(teacherHoliday);
        }

        return teacherHoliday();
    }

    private String getMonthHoliday(Calendar calendar, TeacherDefaultHoliday teacherDefaultHoliday, List<TeacherHoliday> holidayList) {
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        int days = DateHelp.getDaysInMonth(calendar);
        int week = DateHelp.getWeek(calendar);
        for (i = 1; i < week; i++) {
            if (i == 1)
                stringBuilder.append("<tr>\r\n");
            stringBuilder.append("<td></td>\r\n");
        }

        for (i = 1; i <= days; i++) {
            week = DateHelp.getWeek(calendar);
            if (week % 7 == 1)
                stringBuilder.append("<tr>\r\n");
            if (DateHelp.isHoliday(calendar, teacherDefaultHoliday, holidayList)) {
                stringBuilder.append("<td>" + i + "休息" + "</td>");
            } else {
                stringBuilder.append("<td>" + i + "</td>");
            }

            if (week % 7 == 0)
                stringBuilder.append("</tr>\r\n");


            calendar.add(Calendar.DAY_OF_MONTH, 1);

        }

        for (; week < 7; week++) {
            stringBuilder.append("<td></td>\r\n");
            if (week + 1 == 7)
                stringBuilder.append("</tr>\r\n");
        }

        return stringBuilder.toString();
    }

    private String getLastMonthHoliday(Calendar calendar, TeacherDefaultHoliday teacherDefaultHoliday, List<TeacherHoliday> holidayList) {
        Calendar changeCalendar = (Calendar) calendar.clone();
        calendar.add(Calendar.MONTH, -1);
        return getMonthHoliday(changeCalendar, teacherDefaultHoliday, holidayList);
    }

    private String getThisMonthHoliday(Calendar calendar, TeacherDefaultHoliday teacherDefaultHoliday, List<TeacherHoliday> holidayList) {
        Calendar changeCalendar = (Calendar) calendar.clone();
        return getMonthHoliday(changeCalendar, teacherDefaultHoliday, holidayList);
    }

    private String getNextMonthHoliday(Calendar calendar, TeacherDefaultHoliday teacherDefaultHoliday, List<TeacherHoliday> holidayList) {
        Calendar changeCalendar = (Calendar) calendar.clone();
        calendar.add(Calendar.MONTH, -1);
        return getMonthHoliday(changeCalendar, teacherDefaultHoliday, holidayList);
    }
}
