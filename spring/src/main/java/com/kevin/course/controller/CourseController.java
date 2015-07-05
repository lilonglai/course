package com.kevin.course.controller;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.object.SecondCourse;
import com.kevin.course.operation.business.IFirstCourseBusinessOperation;
import com.kevin.course.operation.business.ISecondCourseBusinessOperation;
import com.kevin.course.utils.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by loli on 2015/6/18.
 */
@Controller
public class CourseController {
    @Autowired
    private IFirstCourseBusinessOperation firstCourseOperation;
    @Autowired
    private ISecondCourseBusinessOperation secondCourseOperation;

    @RequestMapping(value = "course", method = RequestMethod.GET)
    public ModelAndView getAll(Integer grade) {
        if (grade == null)
            grade = 3;
        List<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(grade);
        List<SecondCourse> secondCourseList = secondCourseOperation.getByGrade(grade);

        List<FirstCourse> firstCourseList2 = new ArrayList<>();
        for(SecondCourse secondCourse: secondCourseList){
            firstCourseList2.add(firstCourseOperation.get(secondCourse.getFirstCourseId()));
        }

        ModelAndView model = new ModelAndView("course");
        model.addObject("grade", grade);
        model.addObject("firstCourseList", firstCourseList);
        model.addObject("secondCourseList", secondCourseList);
        model.addObject("firstCourseList2", firstCourseList2);
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
        ModelAndView model = new ModelAndView("redirect:course.html");
        return model;
    }

    @RequestMapping( value = "firstCourseUpdate", method = RequestMethod.GET)
    public ModelAndView firstCourseUpdate(int id){
        FirstCourse firstCourse = firstCourseOperation.get(id);
        ModelAndView model = new ModelAndView("firstCourseUpdate");
        model.addObject("firstCourse", firstCourse);
        return model;
    }

    @RequestMapping( value = "firstCourseUpdateSubmit", method = RequestMethod.GET)
    public ModelAndView firstCourseUpdateSubmit(HttpServletRequest request) throws UnsupportedEncodingException {
        FirstCourse firstCourse = null;
        int courseId = HttpRequestUtil.getInt(request, "id");
        firstCourse = firstCourseOperation.get(courseId);
        setObject(request, firstCourse);
        firstCourseOperation.update(firstCourse);
        ModelAndView model = new ModelAndView("redirect:course.html");
        return model;
    }

    @RequestMapping( value = "firstCourseDelete", method = RequestMethod.GET)
    private ModelAndView firstCoursedDelete(int id) {
        firstCourseOperation.delete(id);
        ModelAndView model = new ModelAndView("redirect:course.html");
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
        ModelAndView model = new ModelAndView("redirect:course.html");
        return model;
    }

    @RequestMapping( value = "secondCourseUpdate", method = RequestMethod.GET)
    public ModelAndView secondCourseUpdate(int id){
        SecondCourse secondCourse = null;
        secondCourse = secondCourseOperation.get(id);

        int firstCourseId = secondCourse.getFirstCourseId();
        FirstCourse firstCourse = firstCourseOperation.get(firstCourseId);
        int grade = firstCourse.getGrade();
        List<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(grade);

        ModelAndView model = new ModelAndView("secondCourseUpdate");
        model.addObject("secondCourse", secondCourse);
        model.addObject("firstCourse", firstCourse);
        model.addObject("firstCourseList", firstCourseList);
        return model;
    }

    @RequestMapping( value = "secondCourseUpdateSubmit", method = RequestMethod.GET)
    public ModelAndView secondCourseUpdateSubmit(HttpServletRequest request) throws UnsupportedEncodingException {
        SecondCourse secondCourse = null;
        int courseId = HttpRequestUtil.getInt(request, "id");
        secondCourse = secondCourseOperation.get(courseId);
        setObject(request, secondCourse);

        secondCourseOperation.update(secondCourse);
        ModelAndView model = new ModelAndView("redirect:course.html");
        return model;
    }

    private void setObject(HttpServletRequest request, FirstCourse firstCourse) throws UnsupportedEncodingException{
        firstCourse.setGrade(HttpRequestUtil.getInt(request,"grade"));
        firstCourse.setName(HttpRequestUtil.getString(request,"name"));
        firstCourse.setShortName(HttpRequestUtil.getString(request, "shortName"));
        firstCourse.setDescription(HttpRequestUtil.getString(request, "description"));
    }

    @RequestMapping( value = "secondCourseDelete", method = RequestMethod.GET)
    private ModelAndView secondCourseDelete(int id) {
        secondCourseOperation.delete(id);
        ModelAndView model = new ModelAndView("redirect:course.html");
        return model;
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
