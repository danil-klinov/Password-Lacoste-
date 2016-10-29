package ru.kpfu.itis.group501.klinov.servlets;

import ru.kpfu.itis.group501.klinov.helpers.Helper;
import ru.kpfu.itis.group501.klinov.helpers.RegEx;
import ru.kpfu.itis.group501.klinov.helpers.Token;
import ru.kpfu.itis.group501.klinov.services.TokenService;
import ru.kpfu.itis.group501.klinov.services.UserService;
import ru.kpfu.itis.group501.klinov.services.UserServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class RegestrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String login = request.getParameter("login").toLowerCase();

        RegEx x = new RegEx();


        String password = request.getParameter("password");
        String passwordAgain = request.getParameter("passwordAgain");
        String email= request.getParameter("mail");
        String town = request.getParameter("town");
        String about = request.getParameter("about");
        if (x.IsRight(name)) {
            UserServiceInterface us = new UserService();
            us.add(name, login, password, passwordAgain, email, town, about);
            if (us.getError() == null) {
                Cookie cookie = new Cookie("language", "russian");
                cookie.setMaxAge(30 * 24 * 60 * 60 * 364);
                response.addCookie(cookie);
                response.sendRedirect("/login");
            }
            else{
                response.sendRedirect("/regestration?err="+us.getError().getMessage());
            }
        }
        else{
            response.sendRedirect("/regestration");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> root = new HashMap<>();

        root.put("err", request.getParameter("err"));

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Helper.render(request,response,"regestration.ftl",(HashMap) root);

    }
}
