package com.kevin.course.action;

import com.kevin.course.object.Student;
import com.kevin.course.object.Teacher;
import com.kevin.course.operation.business.IStudentBusinessOperation;
import com.kevin.course.operation.business.ITeacherBusinessOperation;
import com.kevin.course.operation.business.StudentBusinessOperation;
import com.kevin.course.operation.business.TeacherBusinessOperation;
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
        @Result(name = "student", location = "/student.jsp"),
        @Result(name = "studentAdd", location = "/studentAdd.jsp"),
        @Result(name = "studentUpdate", location = "/studentUpdate.jsp"),
        @Result(name = "redirect:student.html", location = "/student.html", type = "redirect")})
public class StudentAction {

    private IStudentBusinessOperation studentOperation = new StudentBusinessOperation();

    private ITeacherBusinessOperation teacherOperation = new TeacherBusinessOperation();

    @Action("student")
    public String getAll(){
        HttpServletRequest request = ServletActionContext.getRequest();
        Integer status = HttpRequestUtil.getInt(request, "status");
        List<Student> list = null;
        if(status == null){
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

        request.setAttribute("status", status);
        request.setAttribute("studentList", list);
        request.setAttribute("teacherOperation", teacherOperation);
        return "student";
    }

    @Action("studentAdd")
    public String studentAdd(){
        HttpServletRequest request = ServletActionContext.getRequest();
        List<Teacher> teacherList = teacherOperation.getAll();
        request.setAttribute("teacherList", teacherList);
        return "studentAdd";
    }

    @Action("studentAddSubmit")
    public String studentAddSubmit() throws UnsupportedEncodingException {
        HttpServletRequest request = ServletActionContext.getRequest();
        Student student = new Student();
        setObject(request, student);
        student.setIsAlive(true);
        studentOperation.add(student);
        return "redirect:student.html";
    }

    @Action("studentUpdate")
    public String studentUpdate(){
        HttpServletRequest request = ServletActionContext.getRequest();
        int id = HttpRequestUtil.getInt(request, "id");
        Student student = studentOperation.get(id);
        List<Teacher> teacherList = teacherOperation.getAll();
        request.setAttribute("student", student);
        request.setAttribute("teacherList", teacherList);
        return "studentUpdate";
    }

    @Action("studentUpdateSubmit")
    public String studentUpdateSubmit() throws UnsupportedEncodingException {
        HttpServletRequest request = ServletActionContext.getRequest();
        int studentId = HttpRequestUtil.getInt(request, "id");
        Student student;
        student = studentOperation.get(studentId);
        setObject(request, student);
        studentOperation.update(student);
        return "redirect:student.html";
    }

    @Action("studentDelete")
    private String studentDelete() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int id = HttpRequestUtil.getInt(request, "id");
        studentOperation.delete(id);
        return "redirect:student.html";
    }

    @Action("studentRetire")
    private String studentRetire() {
        HttpServletRequest request = ServletActionContext.getRequest();
        int id = HttpRequestUtil.getInt(request, "id");
        studentOperation.retire(id);
        return "redirect:student.html";
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
