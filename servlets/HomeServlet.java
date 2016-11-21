package ru.kpfu.itis.group501.klinov.servlets;

import ru.kpfu.itis.group501.klinov.entites.User;
import ru.kpfu.itis.group501.klinov.helpers.Helper;
import ru.kpfu.itis.group501.klinov.services.StoriesService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HomeServlet extends HttpServlet {

    public void init() throws ServletException {}

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> root = new HashMap<>();

        root.put("err", request.getParameter("err"));
        root.put("login", request.getParameter("login"));

        StoriesService ss = new StoriesService();

        User user = (User) request.getSession().getAttribute("current_user");

        if (user != null) {
            root.put("favourites", ss.getAll(Integer.parseInt(user.getId())));
            root.put("avto", "yes");
        }
        else
            root.put("avto", "no");


        root.put("top", ss.getTop());

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Helper.render(request,response,"home.ftl",(HashMap) root);

    }

}