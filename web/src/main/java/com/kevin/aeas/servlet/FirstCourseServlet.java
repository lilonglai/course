package com.kevin.aeas.servlet;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.operation.db.FirstCourseOperation;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.utils.HttpRequestUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by loli on 2015/3/8.
 */
public class FirstCourseServlet extends HttpServlet {
    private void delete(int firstCourseId){
        FirstCourseOperation firstCourseOperation = OperationManager.getInstance().getFirstCourseOperation();
        firstCourseOperation.delete(firstCourseId);
    }

    private void add(HttpServletRequest request) throws UnsupportedEncodingException{
        FirstCourse firstCourse = null;
        FirstCourseOperation firstCourseOperation = OperationManager.getInstance().getFirstCourseOperation();
        firstCourse = new FirstCourse();
        setObject(request, firstCourse);
        firstCourseOperation.add(firstCourse);

    }

    private void setObject(HttpServletRequest request, FirstCourse firstCourse) throws UnsupportedEncodingException{
        firstCourse.setGrade(HttpRequestUtil.getInt(request,"grade"));
        firstCourse.setName(HttpRequestUtil.getString(request,"name"));
        firstCourse.setShortName(HttpRequestUtil.getString(request, "shortName"));
        firstCourse.setDescription(HttpRequestUtil.getString(request, "description"));
    }

    private void update(HttpServletRequest request) throws UnsupportedEncodingException{
        FirstCourse firstCourse = null;
        FirstCourseOperation firstCourseOperation = OperationManager.getInstance().getFirstCourseOperation();
        int courseId = HttpRequestUtil.getInt(request, "id");
        firstCourse = firstCourseOperation.get(courseId);
        setObject(request, firstCourse);
        firstCourseOperation.update(firstCourse);

    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("delete")) {
            int firstCourseId = Integer.valueOf(request.getParameter("id"));
            delete(firstCourseId);
            response.sendRedirect("course.jsp" + "?grade=" + request.getParameter("grade"));
        } else if (action.equals("add")) {
            add(request);
            response.sendRedirect("course.jsp" + "?grade=" + request.getParameter("grade"));
        } else if (action.equals("update")) {
            update(request);
            response.sendRedirect("course.jsp" + "?grade=" + request.getParameter("grade"));
        }
    }
}
