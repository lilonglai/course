package com.kevin.course.controller;

import com.kevin.course.object.Student;
import com.kevin.course.object.Teacher;
import com.kevin.course.operation.business.StudentBusinessOperation;
import com.kevin.course.operation.business.TeacherBusinessOperation;
import com.kevin.course.utils.HttpRequestUtil;
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
public class StudentController {
    private StudentBusinessOperation studentOperation;
    private TeacherBusinessOperation teacherOperation;

    @RequestMapping( value = "student", method = RequestMethod.GET)
    public ModelAndView getAll(int status){
        List<Student> list = null;
        if(status == 0){
            status = 2;
        }
        switch(status){
            case 1:
                list = studentOperation.getAll();
                break;
            case 2:
                list = studentOperation.getAlive();
                break;
            case 3:
                list = studentOperation.getNotAlive();
                break;
        }

        ModelAndView model = new ModelAndView("student");
        model.addObject("studentList", list);
        return model;
    }

    @RequestMapping( value = "studentAdd", method = RequestMethod.GET)
    public ModelAndView studentAdd(){
        List<Teacher> teacherList = teacherOperation.getAll();
        ModelAndView model = new ModelAndView("studentAdd");
        model.addObject("teacherList", teacherList);
        return model;
    }

    @RequestMapping( value = "studentAddSubmit", method = RequestMethod.GET)
    public ModelAndView studentAddSubmit(HttpServletRequest request) throws UnsupportedEncodingException {
        Student student = new Student();
        setObject(request, student);
        student.setIsAlive(true);
        studentOperation.add(student);
        ModelAndView model = new ModelAndView("student");
        return model;
    }

    @RequestMapping( value = "studentUpdate", method = RequestMethod.GET)
    public ModelAndView studentUpdate(int id){
        Student student = studentOperation.get(id);
        List<Teacher> teacherList = teacherOperation.getAll();
        ModelAndView model = new ModelAndView("teacherUpdate");
        model.addObject("student", student);
        model.addObject("teacherList", teacherList);
        return model;
    }

    @RequestMapping( value = "studentUpdateSubmit", method = RequestMethod.GET)
    public ModelAndView studentUpdateSubmit(HttpServletRequest request) throws UnsupportedEncodingException {
        Student student;
        int studentId = HttpRequestUtil.getInt(request, "id");
        student = studentOperation.get(studentId);
        setObject(request, student);
        studentOperation.update(student);
        ModelAndView model = new ModelAndView("student");
        return model;
    }

    @RequestMapping( value = "studentDelete", method = RequestMethod.GET)
    private ModelAndView studentDelete(int id) {
        studentOperation.delete(id);
        ModelAndView model = new ModelAndView("teacher");
        return model;
    }

    @RequestMapping( value = "studentRetire", method = RequestMethod.GET)
    private ModelAndView studentRetire(int id) {
        studentOperation.retire(id);
        ModelAndView model = new ModelAndView("teacher");
        return model;
    }

    private void setObject(HttpServletRequest request, Student student) throws UnsupportedEncodingException{
        student.setName(HttpRequestUtil.getString(request, "name"));
        student.setShortName(HttpRequestUtil.getString(request, "shortName"));
        student.setGrade(HttpRequestUtil.getInt(request, "grade"));
        student.setTestScore(HttpRequestUtil.getString(request, "testScore"));
        student.setTargetScore(HttpRequestUtil.getString(request, "targetScore"));
        student.setExamineDate(HttpRequestUtil.getDate(request, "examineDate"));
        student.setExaminePlace(HttpRequestUtil.getString(request, "examinePlace"));
        student.setTeacherId(HttpRequestUtil.getInt(request, "teacherId"));
        student.setDescription(HttpRequestUtil.getString(request, "description"));
    }
}
