package com.kevin.aeas.servlet;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.operation.db.FirstCourseOperation;
import com.kevin.aeas.operation.db.OperationManager;

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

        firstCourse.setGrade(Integer.valueOf(request.getParameter("grade")));
        String name = request.getParameter("name");
        name = new String(name.getBytes("iso-8859-1"), "utf-8");
        firstCourse.setName(name);

        String shortName = request.getParameter("shortName");
        shortName = new String(shortName.getBytes("iso-8859-1"),
                "utf-8");
        firstCourse.setShortName(shortName);

        String description = request.getParameter("description");
        description = new String(description.getBytes("iso-8859-1"),
                "utf-8");
        firstCourse.setDescription(description);

        firstCourseOperation.add(firstCourse);

    }

    private void update(HttpServletRequest request) throws UnsupportedEncodingException{
        FirstCourse firstCourse = null;
        FirstCourseOperation firstCourseOperation = OperationManager.getInstance().getFirstCourseOperation();
        int courseId = Integer.valueOf(request.getParameter("id"));
        firstCourse = firstCourseOperation.get(courseId);

        firstCourse.setGrade(Integer.valueOf(request.getParameter("grade")));
        String name = request.getParameter("name");
        name = new String(name.getBytes("iso-8859-1"), "utf-8");
        firstCourse.setName(name);

        String shortName = request.getParameter("shortName");
        shortName = new String(shortName.getBytes("iso-8859-1"),
                "utf-8");
        firstCourse.setShortName(shortName);

        String description = request.getParameter("description");
        description = new String(description.getBytes("iso-8859-1"),
                "utf-8");
        firstCourse.setDescription(description);

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
