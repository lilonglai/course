package com.kevin.course.controller;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.object.Teacher;
import com.kevin.course.object.TeacherAbility;
import com.kevin.course.operation.business.FirstCourseBusinessOperation;
import com.kevin.course.operation.business.TeacherAbilityBusinessOperation;
import com.kevin.course.operation.business.TeacherBusinessOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by loli on 2015/6/18.
 */
@Controller
public class TeacherAbilityController {
    @Autowired
    private TeacherBusinessOperation teacherOperation;
    @Autowired
    private TeacherAbilityBusinessOperation teacherAbilityOperation;
    @Autowired
    private FirstCourseBusinessOperation firstCourseOperation;

    @RequestMapping( value = "teacherAbility.html", method = RequestMethod.GET)
    public ModelAndView teacherAbility(int teacherId, int grade){
        if(grade == 0){
            grade = 3;
        }

        Teacher teacher = teacherOperation.get(teacherId);
        List<TeacherAbility> teacherAbilityList = teacherAbilityOperation.getByTeacherId(teacherId);

        List<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(grade);
        List<FirstCourse> selectedFirstCourseList =new ArrayList<FirstCourse>();
        for(int i = 0; i < teacherAbilityList.size(); i++){
            TeacherAbility teacherAbility = teacherAbilityList.get(i);
            for(int j = 0; j<firstCourseList.size(); j++){
                if(teacherAbilityList.get(i).getCourseId() == firstCourseList.get(j).getId()){
                    selectedFirstCourseList.add(firstCourseList.get(j));
                    firstCourseList.remove(j);
                }
            }
        }

        List<FirstCourse> allFirstCourseList = new ArrayList<FirstCourse>();
        for(TeacherAbility teacherAbility : teacherAbilityList) {
            FirstCourse firstCourse = firstCourseOperation.get(teacherAbility.getCourseId());
            allFirstCourseList.add(firstCourse);
        }

        ModelAndView model = new ModelAndView("teacherAbility");
        model.addObject("teacher", teacher);
        model.addObject("firstCourseList", firstCourseList);
        model.addObject("selectedFirstCourseList", selectedFirstCourseList);
        model.addObject("allFirstCourseList", allFirstCourseList);
        model.addObject("grade", grade);

        return model;
    }


    @RequestMapping( value = "teacherAbilitySubmit", method = RequestMethod.GET)
    public ModelAndView teacherAbilitySubmit(int teacherId, int grade, String[] chosenCourses){
        if(grade == 0){
            grade = 3;
        }

        //teacherAbilityOperation.deleteByTeacherId(teacherId);
        teacherAbilityOperation.deleteByTeacherAndGrade(teacherId, grade);
        TeacherAbility teacherAbility = new TeacherAbility();
        teacherAbility.setTeacherId(teacherId);
        if(chosenCourses != null){
            for(String chosenCourse:chosenCourses){
                teacherAbility.setCourseId(Integer.valueOf(chosenCourse));
                teacherAbilityOperation.add(teacherAbility);
            }
        }

        return teacherAbility(teacherId, grade);
    }
}
