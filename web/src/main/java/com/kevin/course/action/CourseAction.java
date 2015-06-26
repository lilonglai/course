package com.kevin.course.action;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.object.SecondCourse;
import com.kevin.course.operation.business.FirstCourseBusinessOperation;
import com.kevin.course.operation.business.SecondCourseBusinessOperation;
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
        @Result(name = "course", location = "/course.jsp"),
        @Result(name = "firstCourseAdd", location = "/firstCourseAdd.jsp"),
        @Result(name = "firstCourseUpdate", location = "/firstCourseUpdate.jsp"),
        @Result(name = "secondCourseAdd", location = "/secondCourseAdd.jsp"),
        @Result(name = "secondCourseUpdate", location = "/secondCourseUpdate.jsp"),
        @Result(name = "redirect:course.html", location = "/course.html", type = "redirect")})
public class CourseAction {
    private FirstCourseBusinessOperation firstCourseOperation = new FirstCourseBusinessOperation();
    private SecondCourseBusinessOperation secondCourseOperation = new SecondCourseBusinessOperation();

    @Action("course")
    public String getAll(Integer grade) {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (grade == null)
            grade = 3;
        List<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(grade);
        List<SecondCourse> secondCourseList = secondCourseOperation.getByGrade(grade);

        request.setAttribute("grade", grade);
        request.setAttribute("firstCourseList", firstCourseList);
        request.setAttribute("secondCourseList", secondCourseList);
        return "course";
    }

    @Action("firstCourseAdd")
    public String firstCourseAdd(int grade) {
        return "firstCourseAdd";
    }

    @Action("firstCourseAddSubmit")
    public String firstCourseAddSubmit() throws UnsupportedEncodingException {
        HttpServletRequest request = ServletActionContext.getRequest();
        FirstCourse firstCourse = null;
        firstCourse = new FirstCourse();
        setObject(request, firstCourse);
        firstCourseOperation.add(firstCourse);
        return "redirect:course.html";
    }

    @Action("firstCourseUpdate")
    public String firstCourseUpdate() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int id = HttpRequestUtil.getInt(request, "id");
        FirstCourse firstCourse = firstCourseOperation.get(id);
        request.setAttribute("firstCourse", firstCourse);
        return "firstCourseUpdate";
    }

    @Action("firstCourseUpdateSubmit")
    public String firstCourseUpdateSubmit() throws UnsupportedEncodingException {
        HttpServletRequest request = ServletActionContext.getRequest();
        FirstCourse firstCourse = null;
        int courseId = HttpRequestUtil.getInt(request, "id");
        firstCourse = firstCourseOperation.get(courseId);
        setObject(request, firstCourse);
        firstCourseOperation.update(firstCourse);
        return "redirect:course.html";
    }

    @Action("firstCourseDelete")
    private String firstCoursedDelete() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int id = HttpRequestUtil.getInt(request, "id");
        firstCourseOperation.delete(id);
        return "redirect:course.html";
    }


    @Action("secondCourseAdd")
    public String secondCourseAdd() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int firstCourseId = HttpRequestUtil.getInt(request, "firstCourseId");
        FirstCourse firstCourse = firstCourseOperation.get(firstCourseId);
        int grade = firstCourse.getGrade();
        List<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(grade);
        request.setAttribute("firstCourse", firstCourse);
        request.setAttribute("firstCourseList", firstCourseList);
        return "secondCourseAdd";
    }

    @Action("secondCourseAddSubmit")
    public String secondCourseAddSubmit() throws UnsupportedEncodingException {
        HttpServletRequest request = ServletActionContext.getRequest();
        SecondCourse secondCourse = null;
        secondCourse = new SecondCourse();
        setObject(request, secondCourse);
        secondCourseOperation.add(secondCourse);
        return "redirect:course.html";
    }

    @Action("secondCourseUpdate")
    public String secondCourseUpdate() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int id = HttpRequestUtil.getInt(request, "id");
        SecondCourse secondCourse = null;
        secondCourse = secondCourseOperation.get(id);

        int firstCourseId = secondCourse.getFirstCourseId();
        FirstCourse firstCourse = firstCourseOperation.get(firstCourseId);
        int grade = firstCourse.getGrade();
        List<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(grade);

        request.setAttribute("secondCourse", secondCourse);
        request.setAttribute("firstCourse", firstCourse);
        request.setAttribute("firstCourseList", firstCourseList);
        return "secondCourseUpdate";
    }

    @Action("secondCourseUpdateSubmit")
    public String secondCourseUpdateSubmit() throws UnsupportedEncodingException {
        HttpServletRequest request = ServletActionContext.getRequest();
        SecondCourse secondCourse = null;
        int courseId = HttpRequestUtil.getInt(request, "id");
        secondCourse = secondCourseOperation.get(courseId);
        setObject(request, secondCourse);

        secondCourseOperation.update(secondCourse);
        return "redirect:course.html";
    }

    private void setObject(HttpServletRequest request, FirstCourse firstCourse) throws UnsupportedEncodingException {
        firstCourse.setGrade(HttpRequestUtil.getInt(request, "grade"));
        firstCourse.setName(HttpRequestUtil.getString(request, "name"));
        firstCourse.setShortName(HttpRequestUtil.getString(request, "shortName"));
        firstCourse.setDescription(HttpRequestUtil.getString(request, "description"));
    }

    @Action("secondCourseDelete")
    private String secondCourseDelete() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int id = HttpRequestUtil.getInt(request, "id");
        secondCourseOperation.delete(id);
        return "redirect:course.html";
    }

    private void setObject(HttpServletRequest request, SecondCourse secondCourse) throws UnsupportedEncodingException {
        int firstCourseId = HttpRequestUtil.getInt(request, "firstCourseId");
        FirstCourse firstCourse = firstCourseOperation.get(firstCourseId);

        secondCourse.setFirstCourseId(firstCourse.getId());
        secondCourse.setName(HttpRequestUtil.getString(request, "name"));
        secondCourse.setShortName(HttpRequestUtil.getString(request, "shortName"));
        secondCourse.setDescription(HttpRequestUtil.getString(request, "description"));
    }
}
