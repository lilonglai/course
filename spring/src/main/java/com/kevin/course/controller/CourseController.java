package com.kevin.course.controller;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.object.SecondCourse;
import com.kevin.course.operation.business.FirstCourseBusinessOperation;
import com.kevin.course.operation.business.SecondCourseBusinessOperation;
import com.kevin.course.utils.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CourseController {
    @Autowired
    private FirstCourseBusinessOperation firstCourseOperation;
    @Autowired
    private SecondCourseBusinessOperation secondCourseOperation;

    @RequestMapping(value = "course", method = RequestMethod.GET)
    public ModelAndView getAll(int grade) {
        if (grade == 0)
            grade = 3;
        List<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(grade);
        List<SecondCourse> secondCourseList = secondCourseOperation.getByGrade(grade);

        ModelAndView model = new ModelAndView("course");
        model.addObject("grade", grade);
        model.addObject("firstCourseList", firstCourseList);
        model.addObject("secondCourseList", secondCourseList);
        return model;
    }

    @RequestMapping( value = "firstCourseAdd", method = RequestMethod.GET)
    public ModelAndView firstCourseAdd(int grade){
        ModelAndView model = new ModelAndView("firstCourseAdd");
        return model;
    }

    @RequestMapping( value = "firstCourseAddSubmit", method = RequestMethod.GET)
    public ModelAndView firstCourseAddSubmit(HttpServletRequest request) throws UnsupportedEncodingException {
        FirstCourse firstCourse = null;
        firstCourse = new FirstCourse();
        setObject(request, firstCourse);
        firstCourseOperation.add(firstCourse);
        ModelAndView model = new ModelAndView("course");
        return model;
    }

    @RequestMapping( value = "firstCourseUpdate", method = RequestMethod.GET)
    public ModelAndView firstCourseUpdate(int id){
        FirstCourse firstCourse = firstCourseOperation.get(id);
        ModelAndView model = new ModelAndView("firstCourseUpdate");
        model.addObject("firstCourse", firstCourse);
        return model;
    }

    @RequestMapping( value = "firstCourseSubmit", method = RequestMethod.GET)
    public ModelAndView firstCourseUpdateSubmit(HttpServletRequest request) throws UnsupportedEncodingException {
        FirstCourse firstCourse = null;
        int courseId = HttpRequestUtil.getInt(request, "id");
        firstCourse = firstCourseOperation.get(courseId);
        setObject(request, firstCourse);
        firstCourseOperation.update(firstCourse);
        ModelAndView model = new ModelAndView("course");
        return model;
    }

    @RequestMapping( value = "firstCoursedDelete", method = RequestMethod.GET)
    private ModelAndView firstCoursedDelete(int id) {
        firstCourseOperation.delete(id);
        ModelAndView model = new ModelAndView("course");
        return model;
    }


    @RequestMapping( value = "secondCourseAdd", method = RequestMethod.GET)
    public ModelAndView secondCourseAdd(int firstCourseId){
        FirstCourse firstCourse = firstCourseOperation.get(firstCourseId);
        int grade = firstCourse.getGrade();
        List<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(grade);
        ModelAndView model = new ModelAndView("secondCourseAdd");
        model.addObject("firstCourse", firstCourse);
        model.addObject("firstCourseList", firstCourseList);
        return model;
    }

    @RequestMapping( value = "secondCourseAddSubmit", method = RequestMethod.GET)
    public ModelAndView secondCourseAddSubmit(HttpServletRequest request) throws UnsupportedEncodingException {
        SecondCourse secondCourse = null;
        secondCourse = new SecondCourse();
        setObject(request, secondCourse);
        secondCourseOperation.add(secondCourse);
        ModelAndView model = new ModelAndView("course");
        return model;
    }

    @RequestMapping( value = "secondCourseUpdate", method = RequestMethod.GET)
    public ModelAndView secondCourseUpdate(int secondCourseId){
        SecondCourse secondCourse = null;
        secondCourse = secondCourseOperation.get(secondCourseId);

        int firstCourseId = secondCourse.getFirstCourseId();
        FirstCourse firstCourse = firstCourseOperation.get(firstCourseId);
        int grade = firstCourse.getGrade();
        List<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(grade);

        ModelAndView model = new ModelAndView("course");
        model.addObject("secondCourse", secondCourse);
        model.addObject("firstCourse", firstCourse);
        model.addObject("firstCourseList", firstCourseList);
        return model;
    }

    @RequestMapping( value = "secondCourseSubmit", method = RequestMethod.GET)
    public ModelAndView secondCourseSubmit(HttpServletRequest request) throws UnsupportedEncodingException {
        SecondCourse secondCourse = null;
        int courseId = HttpRequestUtil.getInt(request, "id");
        secondCourse = secondCourseOperation.get(courseId);
        setObject(request, secondCourse);

        secondCourseOperation.update(secondCourse);
        ModelAndView model = new ModelAndView("course");
        return model;
    }

    private void setObject(HttpServletRequest request, FirstCourse firstCourse) throws UnsupportedEncodingException{
        firstCourse.setGrade(HttpRequestUtil.getInt(request,"grade"));
        firstCourse.setName(HttpRequestUtil.getString(request,"name"));
        firstCourse.setShortName(HttpRequestUtil.getString(request, "shortName"));
        firstCourse.setDescription(HttpRequestUtil.getString(request, "description"));
    }

    private void setObject(HttpServletRequest request, SecondCourse secondCourse) throws UnsupportedEncodingException{
        int firstCourseId = HttpRequestUtil.getInt(request, "firstCourseId");
        FirstCourse firstCourse = firstCourseOperation.get(firstCourseId);

        secondCourse.setFirstCourseId(firstCourse.getId());
        secondCourse.setName(HttpRequestUtil.getString(request, "name"));
        secondCourse.setShortName(HttpRequestUtil.getString(request, "shortName"));
        secondCourse.setDescription(HttpRequestUtil.getString(request, "description"));
    }
}
