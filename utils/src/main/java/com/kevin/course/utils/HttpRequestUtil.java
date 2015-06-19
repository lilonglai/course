package com.kevin.course.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

/**
 * Created by loli on 2015/5/16.
 */
public class HttpRequestUtil {
    public static String getString(HttpServletRequest request, String parameterName) throws UnsupportedEncodingException {
        String parameterValue = request.getParameter(parameterName);
        if (parameterValue != null && !parameterValue.equals(""))
            return new String(parameterValue.getBytes("iso-8859-1"), "utf-8");
        else
            return null;
    }

    public static Date getDate(HttpServletRequest request, String parameterName) {
        String parameterValue = request.getParameter(parameterName);
        if (parameterValue != null && !parameterValue.equals("")) {
            return Date.valueOf(parameterValue);
        }
        else
            return null;
    }

    public static Integer getInt(HttpServletRequest request, String parameterName) {
        String parameterValue = request.getParameter("grade");
        if (parameterValue != null && !parameterValue.equals(""))
        return Integer.valueOf(request.getParameter("grade"));
        else
            return null;
    }
}
