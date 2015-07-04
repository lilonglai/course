package com.kevin.course.controller;

import com.kevin.course.object.SecondCourse;
import com.kevin.course.object.User;
import com.kevin.course.operation.business.IUserBusinessOperation;
import com.kevin.course.utils.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by loli on 2015/6/22.
 */

@Controller
public class UserController {
    @Autowired
    IUserBusinessOperation userBusinessOperation;

    @RequestMapping(value = "userRegister", method = RequestMethod.GET)
    public ModelAndView userRegister(HttpServletRequest request) throws UnsupportedEncodingException {
        ModelAndView model = new ModelAndView("userRegister");
        return model;
    }

    @RequestMapping(value = "userRegisterSubmit", method = RequestMethod.GET)
    public ModelAndView userRegisterSubmit(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        User user = new User();
        setObject(request, user);
        userBusinessOperation.add(user);
        ModelAndView model = new ModelAndView("redirect:index.jsp");
        return model;
    }

    @RequestMapping(value = "userLoginSubmit", method = RequestMethod.GET)
    public ModelAndView userLoginSubmit(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        String userName = HttpRequestUtil.getString(request, "userName");
        String userPassword = HttpRequestUtil.getString(request, "userPassword");

        String userVerifyCode = HttpRequestUtil.getString(request, "userVerifyCode");
        String userVerifyCodeInSession = (String) request.getSession().getAttribute("userVerifyCode");
        if(userVerifyCodeInSession == null || !userVerifyCodeInSession.equals(userVerifyCode)){
            ModelAndView model = new ModelAndView("redirect:userLogin.html");
            return model;
        }

        User user = userBusinessOperation.get(userName, userPassword);
        if (user != null) {
            user.setName(userName);
            user.setPassword(userPassword);
            request.getSession(true).setAttribute("user", user);
            Cookie userCookie = new Cookie("userName", user.getName());
            userCookie.setMaxAge(180);
            Cookie passwordCookie = new Cookie("userPassword", user.getPassword());
            passwordCookie.setMaxAge(180);
            response.addCookie(userCookie);
            response.addCookie(passwordCookie);
            ModelAndView model = new ModelAndView("redirect:index.jsp");
            return model;
        } else {
            ModelAndView model = new ModelAndView("redirect:userLogin.html");
            return model;
        }

    }

    @RequestMapping(value = "userLogin", method = RequestMethod.GET)
    public ModelAndView userLogin(HttpServletRequest request) throws UnsupportedEncodingException {
        if (request.getSession(true).getAttribute("user") != null) {
            ModelAndView model = new ModelAndView("redirect:index.jsp");
            return model;
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
                ModelAndView model = new ModelAndView("redirect:index.jsp");
                return model;
            }
        }

        ModelAndView model = new ModelAndView("userLogin");

        return model;
    }

    @RequestMapping(value = "userVerifyCode", method = RequestMethod.GET)
    public void userVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
        char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        int width = 60;
        int height = 20;
        int codeCount = 4;
        BufferedImage buffImg = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width - 1, height - 1);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        StringBuffer verifyCode = new StringBuffer();

        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(36)]);
            int red = random.nextInt(255);
            int green = random.nextInt(255);
            int blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            g.drawString(strRand, (i + 1) * 13, height-4);
            // 将产生的四个随机数组合在一起。
            verifyCode.append(strRand);
        }

        request.getSession(true).setAttribute("userVerifyCode", verifyCode.toString());
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        g.dispose();

        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(buffImg, "jpeg", sos);
        sos.close();
    }

    private void setObject(HttpServletRequest request, User user) throws UnsupportedEncodingException {
        user.setName(HttpRequestUtil.getString(request, "userName"));
        user.setPassword(HttpRequestUtil.getString(request, "userPassword"));
        user.setEmail(HttpRequestUtil.getString(request, "userEmail"));
        user.setQq(HttpRequestUtil.getString(request, "userQq"));
        user.setPhone(HttpRequestUtil.getString(request, "userTelephone"));
        user.setDescription(HttpRequestUtil.getString(request, "userDescription"));
    }
}
