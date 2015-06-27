package com.kevin.course.action;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.object.Teacher;
import com.kevin.course.object.TeacherAbility;
import com.kevin.course.operation.business.*;
import com.kevin.course.utils.HttpRequestUtil;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by loli on 2015/6/18.
 */

@Results({
        @Result(name = "teacherAbility", location = "/teacherAbility.jsp")})
public class TeacherAbilityAction {
    private ITeacherBusinessOperation teacherOperation = new TeacherBusinessOperation();
    private ITeacherAbilityBusinessOperation teacherAbilityOperation = new TeacherAbilityBusinessOperation();
    private IFirstCourseBusinessOperation firstCourseOperation = new FirstCourseBusinessOperation();

    @Action("teacherAbility")
    public String teacherAbility(){
        HttpServletRequest request = ServletActionContext.getRequest();
        int id = HttpRequestUtil.getInt(request, "id");
        Integer grade = HttpRequestUtil.getInt(request, "grade");

        if(grade == null){
            grade = 3;
        }

        Teacher teacher = teacherOperation.get(id);
        List<TeacherAbility> teacherAbilityList = teacherAbilityOperation.getByTeacherId(id);

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



        request.setAttribute("teacher", teacher);
        request.setAttribute("firstCourseList", firstCourseList);
        request.setAttribute("selectedFirstCourseList", selectedFirstCourseList);
        request.setAttribute("allFirstCourseList", allFirstCourseList);
        request.setAttribute("grade", grade);

        return "teacherAbility";
    }


    @Action("teacherAbilitySubmit")
    public String teacherAbilitySubmit(int id, int grade, String[] chosen){
        if(grade == 0){
            grade = 3;
        }

        //teacherAbilityOperation.deleteByTeacherId(teacherId);
        teacherAbilityOperation.deleteByTeacherAndGrade(id, grade);
        TeacherAbility teacherAbility = new TeacherAbility();
        teacherAbility.setTeacherId(id);
        if(chosen != null){
            for(String chosenCourse:chosen){
                teacherAbility.setCourseId(Integer.valueOf(chosenCourse));
                teacherAbilityOperation.add(teacherAbility);
            }
        }

        return teacherAbility();
    }
}
