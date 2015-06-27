package com.kevin.course.action;

import com.kevin.course.object.Teacher;
import com.kevin.course.object.TeacherDefaultHoliday;
import com.kevin.course.operation.business.ITeacherBusinessOperation;
import com.kevin.course.operation.business.ITeacherDefaultHolidayBusinessOperation;
import com.kevin.course.operation.business.TeacherBusinessOperation;
import com.kevin.course.operation.business.TeacherDefaultHolidayBusinessOperation;
import com.kevin.course.utils.HttpRequestUtil;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by loli on 2015/6/18.
 */
@Results({
        @Result(name = "teacher", location = "/teacher.jsp"),
        @Result(name = "teacherUpdate", location = "/teacherUpdate.jsp"),
        @Result(name = "teacherAdd", location = "/teacherAdd.jsp"),
        @Result(name = "redirect:teacher.html", location = "/teacher.html", type = "redirect")})
public class TeacherAction {

    private ITeacherBusinessOperation teacherOperation = new TeacherBusinessOperation();
    private ITeacherDefaultHolidayBusinessOperation teacherDefaultHolidayOperation = new TeacherDefaultHolidayBusinessOperation();


    List<Teacher> teacherList;
    Integer status;
    Integer id;
    Teacher teacher;
    TeacherDefaultHoliday teacherDefaultHoliday;

    @Action("teacher")
    public String getAll() {
        if (status == null) {
            status = 2;
        }
        switch (status) {
            case 1:
                teacherList = teacherOperation.getAll();
                break;
            case 2:
                teacherList = teacherOperation.getAlive();
                break;
            case 3:
                teacherList = teacherOperation.getNotAlive();
                break;
        }

        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("teacherList", teacherList);
        request.setAttribute("status", status);
        return "teacher";
    }

    @Action("teacherAdd")
    public String teacherAdd() {
        return "teacherAdd";
    }

    @Action("teacherAddSubmit")
    public String teacherAddSubmit() throws UnsupportedEncodingException {
        HttpServletRequest request = ServletActionContext.getRequest();
        Teacher teacher = new Teacher();
        setObject(request, teacher);
        teacher.setIsAlive(true);
        teacherOperation.add(teacher);

        TeacherDefaultHoliday teacherDefaultHoliday = new TeacherDefaultHoliday();
        teacherDefaultHoliday.setTeacherId(teacher.getId());
        setObject(request, teacherDefaultHoliday);
        teacherDefaultHolidayOperation.add(teacherDefaultHoliday);
        return "redirect:teacher.html";
    }

    @Action("teacherUpdate")
    public String teacherUpdate() {
        HttpServletRequest request = ServletActionContext.getRequest();
        id = HttpRequestUtil.getInt(request, "id");

        Teacher teacher = teacherOperation.get(id);
        TeacherDefaultHoliday teacherDefaultHoliday = teacherDefaultHolidayOperation.getByTeacherId(id);
        request.setAttribute("teacher", teacher);
        request.setAttribute("teacherDefaultHoliday", teacherDefaultHoliday);
        return "teacherUpdate";
    }

    @Action("teacherUpdateSubmit")
    public String teacherUpdateSubmit() throws UnsupportedEncodingException {
        HttpServletRequest request = ServletActionContext.getRequest();
        id = HttpRequestUtil.getInt(request, "id");
        Teacher teacher = null;

        int teacherId = id;
        teacher = teacherOperation.get(teacherId);
        setObject(request, teacher);
        teacherOperation.update(teacher);

        TeacherDefaultHoliday teacherDefaultHoliday = teacherDefaultHolidayOperation.getByTeacherId(teacherId);
        if (teacherDefaultHoliday == null) {
            teacherDefaultHoliday = new TeacherDefaultHoliday();
        }
        setObject(request, teacherDefaultHoliday);
        teacherDefaultHoliday.setTeacherId(teacherId);
        if (teacherDefaultHoliday.getId() > 0) {
            teacherDefaultHolidayOperation.update(teacherDefaultHoliday);
        } else {
            teacherDefaultHolidayOperation.add(teacherDefaultHoliday);
        }
        return "redirect:teacher.html";
    }

    @Action("teacherDelete")
    private String teacherDelete() {
        teacherDefaultHolidayOperation.deleteByTeacherId(id);
        teacherOperation.delete(id);
        return "redirect:teacher.html";
    }

    @Action("teacherRetire")
    private String retire() {
        teacherOperation.retire(id);
        return "redirect:teacher.html";
    }


    private void setObject(HttpServletRequest request, Teacher teacher) throws UnsupportedEncodingException {
        teacher.setName(HttpRequestUtil.getString(request, "name"));
        teacher.setShortName(HttpRequestUtil.getString(request, "shortName"));
        teacher.setPhone(request.getParameter("phone"));
        if (request.getParameter("isMaster") != null)
            teacher.setIsMaster(true);
        else
            teacher.setIsMaster(false);
    }

    private void setObject(HttpServletRequest request, TeacherDefaultHoliday teacherDefaultHoliday) throws UnsupportedEncodingException {
        String[] weeks = request.getParameterValues("weeks");
        teacherDefaultHoliday.setWeek1(false);
        teacherDefaultHoliday.setWeek2(false);
        teacherDefaultHoliday.setWeek3(false);
        teacherDefaultHoliday.setWeek4(false);
        teacherDefaultHoliday.setWeek5(false);
        teacherDefaultHoliday.setWeek6(false);
        teacherDefaultHoliday.setWeek7(false);
        if (weeks != null) {
            for (String week : weeks) {
                if ("week1".equals(week))
                    teacherDefaultHoliday.setWeek1(true);
                else if ("week2".equals(week))
                    teacherDefaultHoliday.setWeek2(true);
                else if ("week3".equals(week))
                    teacherDefaultHoliday.setWeek3(true);
                else if ("week4".equals(week))
                    teacherDefaultHoliday.setWeek4(true);
                else if ("week5".equals(week))
                    teacherDefaultHoliday.setWeek5(true);
                else if ("week6".equals(week))
                    teacherDefaultHoliday.setWeek6(true);
                else if ("week7".equals(week))
                    teacherDefaultHoliday.setWeek7(true);
                else {
                    throw new IllegalArgumentException("week must between 1-7");
                }

            }
        }
    }
}
