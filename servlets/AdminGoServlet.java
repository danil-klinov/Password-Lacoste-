package ru.kpfu.itis.group501.klinov.servlets;

import ru.kpfu.itis.group501.klinov.entites.User;
import ru.kpfu.itis.group501.klinov.helpers.Helper;
import ru.kpfu.itis.group501.klinov.services.Comment_storiesService;
import ru.kpfu.itis.group501.klinov.services.StoriesService;
import ru.kpfu.itis.group501.klinov.services.UserService;
import ru.kpfu.itis.group501.klinov.services.UserServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Даниил on 08.11.2016.
 */
public class AdminGoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String parameter = request.getParameter("par");

        if(parameter.equals("users")) {

            String name = request.getParameter("name");
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String passwordAgain = request.getParameter("password");
            String email = request.getParameter("email");
            String town = request.getParameter("town");
            String about = request.getParameter("about");

            UserServiceInterface us = new UserService();
            us.add(name, login, password, passwordAgain, email, town, about);
            if (us.getError() == null) {
                response.sendRedirect("/admingo?par=users");
            } else {
                response.sendRedirect("/admingo?par=users&err=" + us.getError().getMessage());
            }

        }

        if(parameter.equals("deleteuser")){
            String id = request.getParameter("id");
            UserServiceInterface us = new UserService();
            us.delete(id);
            if (us.getError() == null) {
                response.sendRedirect("/admingo?par=users");
            } else {
                response.sendRedirect("/admingo?par=users&err=" + us.getError().getMessage());
            }
        }

        if(parameter.equals("searchusers")){

            Map<String, Object> root = new HashMap<>();

            String text = ("'%" + request.getParameter("search-input") + "%'");

            UserService us = new UserService();

            root.put("users",us.getSearchUsers(text));

            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            Helper.render(request,response,"admingo.ftl",(HashMap) root);

        }

        if(parameter.equals("sortusers")){

            Map<String, Object> root = new HashMap<>();

            String text = ("'%" + request.getParameter("search-input") + "%'");

            UserService us = new UserService();

            root.put("users",us.getSearchUsers(text));

            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            Helper.render(request,response,"admingo.ftl",(HashMap) root);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("current_user");

        if (!user.getIs_admin())
            response.sendRedirect("/home");

        Map<String, Object> root = new HashMap<>();
        String table = request.getParameter("par");

        if (table.equals("users")) {
            UserService us = new UserService();
            root.put("users",us.getAllUsers());
        }


        if (table.equals("comment_stories")){
            Comment_storiesService cs = new Comment_storiesService();
            root.put("comment_stories",cs.getAllComment());
        }

        if (table.equals("stories")){
            StoriesService s = new StoriesService();
            root.put("stories",s.getAllStories());
        }


        if (table.equals("cookies")){

        }

        if (table.equals("favorites")){

        }

        if (table.equals("forum_topic")){

        }

        if (table.equals("message")){

        }

        if (table.equals("offer_story")){

        }

        if (table.equals("photos")){

        }

        if (table.equals("top_stories")){

        }


        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Helper.render(request,response,"admingo.ftl",(HashMap) root);

    }
}
