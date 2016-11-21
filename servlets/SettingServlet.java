package ru.kpfu.itis.group501.klinov.servlets;

import ru.kpfu.itis.group501.klinov.entites.User;
import ru.kpfu.itis.group501.klinov.helpers.Hash;
import ru.kpfu.itis.group501.klinov.helpers.Helper;
import ru.kpfu.itis.group501.klinov.helpers.UpdeatBD;
import ru.kpfu.itis.group501.klinov.services.UserService;
import ru.kpfu.itis.group501.klinov.services.UserServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Даниил on 16.11.2016.
 */
public class SettingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String login = request.getParameter("login").toLowerCase();
        String email= request.getParameter("mail");
        String town = request.getParameter("town");
        String about = request.getParameter("about");
        int id = Integer.parseInt(request.getParameter("id"));

        UpdeatBD ud = new UpdeatBD();

        ud.updeat("users", "name", id, "'" + name + "'");
        ud.updeat("users", "login", id, "'" + login + "'");
        ud.updeat("users", "email", id, "'" + email + "'");
        ud.updeat("users", "town", id, "'" + town + "'");
        ud.updeat("users", "about", id, "'" + about + "'");

        String password = request.getParameter("password");

        password = Hash.getMd5Apache(password);
        ud.updeat("users", "password", id, "'" + password + "'");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        response.sendRedirect("/profile?err=Changes saved");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> root = new HashMap<>();

        User user = (User) request.getSession().getAttribute("current_user");

        root.put("name", user.getName());
        root.put("login", user.getLogin());
        root.put("about", user.getAbout());
        root.put("town", user.getTown());
        root.put("email", user.getEmail());
        root.put("id", user.getId());

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Helper.render(request,response,"setting.ftl",(HashMap) root);

    }
}
