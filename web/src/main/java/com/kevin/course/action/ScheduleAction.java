package com.kevin.course.action;

import com.kevin.course.object.*;
import com.kevin.course.operation.business.*;
import com.kevin.course.utils.HttpRequestUtil;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by loli on 2015/6/18.
 */
@ParentPackage("json-default")
@Results({
        @Result(name = "schedule", location = "/schedule.jsp")})
public class ScheduleAction {
    private IStudentBusinessOperation studentOperation = new StudentBusinessOperation();
    private IFirstCourseBusinessOperation firstCourseOperation = new FirstCourseBusinessOperation();
    private ISecondCourseBusinessOperation secondCourseOperation = new SecondCourseBusinessOperation();
    private ITeacherBusinessOperation teacherOperation = new TeacherBusinessOperation();
    private IScheduleBusinessOperation scheduleOperation = new ScheduleBusinessOperation();

    /* id indicate the studentId*/
    @Action("schedule")
    public String listAll() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int id = HttpRequestUtil.getInt(request, "id");
        Student student = studentOperation.get(id);
        List<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(student.getGrade());
        List<Teacher> teacherList = teacherOperation.getAll();

        List<Schedule> scheduleList = scheduleOperation.getByStudentId(id);
        List<SecondCourse> scheduledSecondCourseList = new ArrayList<SecondCourse>();
        List<Teacher> scheduledTeacherList = new ArrayList<Teacher>();

        for (Schedule schedule : scheduleList) {
            scheduledSecondCourseList.add(secondCourseOperation.get(schedule.getCourseId()));
            scheduledTeacherList.add(teacherOperation.get(schedule.getTeacherId()));
        }

        request.setAttribute("student", student);
        request.setAttribute("firstCourseList", firstCourseList);
        request.setAttribute("teacherList", teacherList);
        request.setAttribute("scheduleList", scheduleList);
        request.setAttribute("totalHours", calculateTotalHours(scheduleList));
        request.setAttribute("scheduledSecondCourseList", scheduledSecondCourseList);
        request.setAttribute("scheduledTeacherList", scheduledTeacherList);
        return "schedule";
    }

    @Action("scheduleAddSubmit")
    public String studentAddSubmit() throws UnsupportedEncodingException {
        HttpServletRequest request = ServletActionContext.getRequest();
        Schedule schedule = new Schedule();
        setObject(request, schedule);
        scheduleOperation.add(schedule);
        return listAll();
    }

    @Action("scheduleDelete")
    public String scheduleDelete() throws UnsupportedEncodingException {
        HttpServletRequest request = ServletActionContext.getRequest();
        int scheduleId = HttpRequestUtil.getInt(request, "scheduleId");
        scheduleOperation.delete(scheduleId);
        return listAll();
    }


    private void setObject(HttpServletRequest request, Schedule schedule) throws UnsupportedEncodingException {
        schedule.setOnDate(HttpRequestUtil.getDate(request, "onDate"));
        schedule.setOnTime(HttpRequestUtil.getInt(request, "onTime"));
        schedule.setStudentId(HttpRequestUtil.getInt(request, "id"));
        schedule.setCourseId(HttpRequestUtil.getInt(request, "secondCourseId"));
        schedule.setTeacherId(HttpRequestUtil.getInt(request, "teacherId"));
        schedule.setDescription(HttpRequestUtil.getString(request, "description"));
    }


    private double calculateTotalHours(List<Schedule> scheduleList) {
        double totalHours = 0;
        for (Schedule schedule : scheduleList) {
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

    @Action(value = "/service/schedule/getSecondCourseList", results = {@Result(name = "jsonResult", type = "json")})
    public String obtainSecondCourseList() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int studentId = HttpRequestUtil.getInt(request, "studentId");
        int firstCourseId = HttpRequestUtil.getInt(request, "firstCourseId");
        List<SecondCourse> secondCourseList = scheduleOperation.getSecondCourseList(studentId, firstCourseId);
        result = secondCourseList;
        return "jsonResult";
    }

    @Action(value = "/service/schedule/getTeacherList",results = {@Result(name = "jsonResult", type = "json")})
    public String ObtainTeacherListByGet() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Date onDate = HttpRequestUtil.getDate(request, "onDate");
        int onTime = HttpRequestUtil.getInt(request, "onTime");
        int firstCourseId = HttpRequestUtil.getInt(request, "firstCourseId");
        List<Teacher> teacherList = scheduleOperation.getTeacherList(onDate, onTime, firstCourseId);
        result = teacherList;
        return "jsonResult";
    }

    @Action(value = "/service/schedule/getAvailableTeacherList", results = {@Result(name = "jsonResult", type = "json")})
    public String obtainAvailableTeacherListByGet() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Date onDate = HttpRequestUtil.getDate(request, "onDate");
        int onTime = HttpRequestUtil.getInt(request, "onTime");
        List<Teacher> teacherList = scheduleOperation.getAvailableTeacherList(onDate, onTime);
        result = teacherList;
        return "jsonResult";
    }

    @Action(value = "/service/schedule/getSecondCourseAndTeacherList", results = {@Result(name = "jsonResult", type = "json")})
    public String obtainSecondCourseAndTeacherListByGet() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Date onDate = HttpRequestUtil.getDate(request, "onDate");
        int onTime = HttpRequestUtil.getInt(request, "onTime");
        int studentId = HttpRequestUtil.getInt(request, "studentId");
        int firstCourseId = HttpRequestUtil.getInt(request, "firstCourseId");
        List<SecondCourse> secondCourseList = scheduleOperation.getSecondCourseList(studentId, firstCourseId);
        List<Teacher> teacherList = scheduleOperation.getTeacherList(onDate, onTime, firstCourseId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("secondCourseList", secondCourseList);
        map.put("teacherList", teacherList);
        result = map;
        return "jsonResult";
    }

    private Object result;
    public Object getResult(){
        return result;
    }
}
