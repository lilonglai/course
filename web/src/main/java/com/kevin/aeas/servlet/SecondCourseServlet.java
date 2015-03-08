package com.kevin.aeas.servlet;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.operation.db.FirstCourseOperation;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.SecondCourseOperation;

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
        FirstCourseOperation firstCourseOperation = OperationManager.getInstance().getFirstCourseOperation();
        secondCourse = new SecondCourse();
        int firstCourseId = Integer.valueOf((request.getParameter("firstCourseId")));
        FirstCourse firstCourse = firstCourseOperation.get(firstCourseId);

        secondCourse.setFirstCourseId(firstCourse.getId());
        String name = request.getParameter("name");
        name = new String(name.getBytes("iso-8859-1"), "utf-8");
        secondCourse.setName(name);

        String shortName = request.getParameter("shortName");
        shortName = new String(shortName.getBytes("iso-8859-1"),
                "utf-8");
        secondCourse.setShortName(shortName);

        String description = request.getParameter("description");
        description = new String(description.getBytes("iso-8859-1"),
                "utf-8");
        secondCourse.setDescription(description);

        secondCourseOperation.add(secondCourse);
    }

    private void update(HttpServletRequest request) throws UnsupportedEncodingException{
        SecondCourse secondCourse = null;
        SecondCourseOperation secondCourseOperation = OperationManager.getInstance().getSecondCourseOperation();
        FirstCourseOperation firstCourseOperation = OperationManager.getInstance().getFirstCourseOperation();
        int courseId = Integer.valueOf(request.getParameter("id"));
        secondCourse = secondCourseOperation.get(courseId);

        String name = request.getParameter("name");
        name = new String(name.getBytes("iso-8859-1"), "utf-8");
        secondCourse.setName(name);

        String shortName = request.getParameter("shortName");
        shortName = new String(shortName.getBytes("iso-8859-1"),
                "utf-8");
        secondCourse.setShortName(shortName);

        int firstCourseId = Integer.valueOf((request.getParameter("firstCourseId")));
        FirstCourse firstCourse = firstCourseOperation.get(firstCourseId);
        secondCourse.setFirstCourseId(firstCourseId);

        String description = request.getParameter("description");
        description = new String(description.getBytes("iso-8859-1"),
                "utf-8");
        secondCourse.setDescription(description);

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
