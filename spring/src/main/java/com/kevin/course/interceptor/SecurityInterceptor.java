package com.kevin.course.interceptor;

import com.kevin.course.object.User;
import com.kevin.course.operation.business.IUserBusinessOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by loli on 2015/7/4.
 */
public class SecurityInterceptor implements HandlerInterceptor {
    @Autowired
    IUserBusinessOperation userBusinessOperation;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession(true).getAttribute("user") != null) {
            return true;
        }
        Cookie[] cookies = request.getCookies();
        String userName = null;
        String userPassword = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userName")) {
                    userName = cookie.getValue();
                }
                if (cookie.getName().equals("userPassword")) {
                    userPassword = cookie.getValue();
                }
            }
        }

        if (userName != null && userPassword != null) {
            User user = userBusinessOperation.get(userName, userPassword);
            if (user != null) {
                request.getSession(true).setAttribute("user", user);
                return true;
            }
        }

        response.sendRedirect("/userLogin.html");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
