package com.kevin.course.servlet;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.object.SecondCourse;
import com.kevin.course.operation.db.FirstCourseOperation;
import com.kevin.course.operation.db.OperationManager;
import com.kevin.course.operation.db.SecondCourseOperation;
import com.kevin.course.utils.HttpRequestUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by loli on 2015/3/8.
 */
public class SecondCourseServlet extends HttpServlet {
    private void delete(int secondCourseId){
        SecondCourseOperation secondCourseOperation = OperationManager.getInstance().getSecondCourseOperation();
        secondCourseOperation.delete(secondCourseId);
    }

    private void add(HttpServletRequest request) throws UnsupportedEncodingException{
        SecondCourse secondCourse = null;
        SecondCourseOperation secondCourseOperation = OperationManager.getInstance().getSecondCourseOperation();
        secondCourse = new SecondCourse();
        setObject(request, secondCourse);
        secondCourseOperation.add(secondCourse);
    }

    private void setObject(HttpServletRequest request, SecondCourse secondCourse) throws UnsupportedEncodingException{
        FirstCourseOperation firstCourseOperation = OperationManager.getInstance().getFirstCourseOperation();
        int firstCourseId = HttpRequestUtil.getInt(request, "firstCourseId");
        FirstCourse firstCourse = firstCourseOperation.get(firstCourseId);

        secondCourse.setFirstCourseId(firstCourse.getId());
        secondCourse.setName(HttpRequestUtil.getString(request, "name"));
        secondCourse.setShortName(HttpRequestUtil.getString(request, "shortName"));
        secondCourse.setDescription(HttpRequestUtil.getString(request, "description"));
    }

    private void update(HttpServletRequest request) throws UnsupportedEncodingException{
        SecondCourse secondCourse = null;
        SecondCourseOperation secondCourseOperation = OperationManager.getInstance().getSecondCourseOperation();
        int courseId = HttpRequestUtil.getInt(request, "id");
        secondCourse = secondCourseOperation.get(courseId);
        setObject(request, secondCourse);

        secondCourseOperation.update(secondCourse);

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
            int secondCourseId = Integer.valueOf(request.getParameter("id"));
            delete(secondCourseId);
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
