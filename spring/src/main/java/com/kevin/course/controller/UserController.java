package com.kevin.course.controller;

import com.kevin.course.object.Teacher;
import com.kevin.course.object.User;
import com.kevin.course.operation.business.UserBusinessOperation;
import com.kevin.course.utils.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by loli on 2015/6/22.
 */
public class UserController {
    @Autowired
    UserBusinessOperation userBusinessOperation;

    @RequestMapping(value = "userRegisterSubmit", method = RequestMethod.GET)
    public ModelAndView userRegisterSubmit(HttpServletRequest request) throws UnsupportedEncodingException {

        User user = new User();
        setObject(request, user);
        userBusinessOperation.add(user);
        ModelAndView model = new ModelAndView("index");
        return model;
    }


    private void setObject(HttpServletRequest request, User user) throws UnsupportedEncodingException {
        user.setName(HttpRequestUtil.getString(request, "userName"));
        user.setPassword(HttpRequestUtil.getString(request, "userPassword"));
        user.setEmail(HttpRequestUtil.getString(request, "userEmail"));
        user.setQq(HttpRequestUtil.getString(request, "userQq"));
        user.setPhone(HttpRequestUtil.getString(request, "userTelephone"));
    }
}
