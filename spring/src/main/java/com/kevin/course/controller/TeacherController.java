package com.kevin.course.controller;

import com.kevin.course.object.Teacher;
import com.kevin.course.object.TeacherDefaultHoliday;
import com.kevin.course.operation.business.TeacherBusinessOperation;
import com.kevin.course.operation.business.TeacherDefaultHolidayBusinessOperation;
import com.kevin.course.utils.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by loli on 2015/6/18.
 */
@Controller
public class TeacherController {
    @Autowired
    private TeacherBusinessOperation teacherOperation;
    @Autowired
    private TeacherDefaultHolidayBusinessOperation teacherDefaultHolidayOperation;

    @RequestMapping( value = "teacher", method = RequestMethod.GET)
    public ModelAndView getAll(Integer status){
        List<Teacher> list = null;
        if(status == null){
            status = 2;
        }
        switch(status){
            case 1:
                list = teacherOperation.getAll();
                break;
            case 2:
                list = teacherOperation.getAlive();
                break;
            case 3:
                list = teacherOperation.getNotAlive();
                break;
        }

        ModelAndView model = new ModelAndView("teacher");
        model.addObject("status", status);
        model.addObject("teacherList", list);
        return model;
    }

    @RequestMapping( value = "teacherAdd", method = RequestMethod.GET)
    public ModelAndView teacherAdd(){
        return  new ModelAndView("teacherAdd");
    }

    @RequestMapping( value = "teacherAddSubmit", method = RequestMethod.GET)
    public ModelAndView teacherAddSubmit(HttpServletRequest request) throws UnsupportedEncodingException {
        Teacher teacher = new Teacher();
        setObject(request, teacher);
        teacher.setIsAlive(true);
        teacherOperation.add(teacher);

        TeacherDefaultHoliday teacherDefaultHoliday = new TeacherDefaultHoliday();
        teacherDefaultHoliday.setTeacherId(teacher.getId());
        setObject(request, teacherDefaultHoliday);
        teacherDefaultHolidayOperation.add(teacherDefaultHoliday);
        ModelAndView model = new ModelAndView("redirect:teacher.html");
        return model;
    }

    @RequestMapping( value = "teacherUpdate", method = RequestMethod.GET)
    public ModelAndView teacherUpdate(int id){
        Teacher teacher = teacherOperation.get(id);
        TeacherDefaultHoliday teacherDefaultHoliday = teacherDefaultHolidayOperation.getByTeacherId(id);
        ModelAndView model = new ModelAndView("teacherUpdate");
        model.addObject("teacher", teacher);
        model.addObject("teacherDefaultHoliday", teacherDefaultHoliday);
        return model;
    }

    @RequestMapping( value = "teacherUpdateSubmit", method = RequestMethod.GET)
    public ModelAndView teacherUpdateSubmit(HttpServletRequest request) throws UnsupportedEncodingException {
        Teacher teacher = null;

        int teacherId = Integer.valueOf(request.getParameter("id"));
        teacher = teacherOperation.get(teacherId);
        setObject(request, teacher);
        teacherOperation.update(teacher);

        TeacherDefaultHoliday teacherDefaultHoliday = teacherDefaultHolidayOperation.getByTeacherId(teacherId);
        if(teacherDefaultHoliday == null){
            teacherDefaultHoliday = new TeacherDefaultHoliday();
        }
        setObject(request, teacherDefaultHoliday);
        teacherDefaultHoliday.setTeacherId(teacherId);
        if(teacherDefaultHoliday.getId() > 0) {
            teacherDefaultHolidayOperation.update(teacherDefaultHoliday);
        }
        else{
            teacherDefaultHolidayOperation.add(teacherDefaultHoliday);
        }
        ModelAndView model = new ModelAndView("redirect:teacher.html");
        return model;
    }

    @RequestMapping( value = "teacherDelete", method = RequestMethod.GET)
    private ModelAndView teacherDelete(int id) {
        teacherDefaultHolidayOperation.deleteByTeacherId(id);
        teacherOperation.delete(id);
        ModelAndView model = new ModelAndView("redirect:teacher.html");
        return model;
    }

    @RequestMapping( value = "teacherRetire", method = RequestMethod.GET)
    private ModelAndView retire(int id) {
        teacherOperation.retire(id);
        ModelAndView model = new ModelAndView("redirect:teacher.html");
        return model;
    }



    private void setObject(HttpServletRequest request, Teacher teacher) throws UnsupportedEncodingException{
        teacher.setName(HttpRequestUtil.getString(request, "name"));
        teacher.setShortName(HttpRequestUtil.getString(request, "shortName"));
        teacher.setPhone(request.getParameter("phone"));
        if (request.getParameter("isMaster") != null)
            teacher.setIsMaster(true);
        else
            teacher.setIsMaster(false);
    }

    private void setObject(HttpServletRequest request, TeacherDefaultHoliday teacherDefaultHoliday) throws UnsupportedEncodingException{
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
