package ru.kpfu.itis.group501.klinov.servlets;

import ru.kpfu.itis.group501.klinov.entites.User;
import ru.kpfu.itis.group501.klinov.helpers.Helper;
import ru.kpfu.itis.group501.klinov.services.ForumService;
import ru.kpfu.itis.group501.klinov.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Даниил on 13.11.2016.
 */
public class ForumServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        User user = (User) request.getSession().getAttribute("current_user");

        ForumService fs = new ForumService();

        fs.add(name,user.getId());

        response.sendRedirect("/forum");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> root = new HashMap<>();

        ForumService fs = new ForumService();
        root.put("topics",fs.getAllTopics());

        User user = (User) request.getSession().getAttribute("current_user");

        if (user != null)
            root.put("avto", "yes");
        else
            root.put("avto", "no");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Helper.render(request,response,"forum.ftl",(HashMap) root);


    }

}
