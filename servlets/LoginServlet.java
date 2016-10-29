package ru.kpfu.itis.group501.klinov.servlets;

import ru.kpfu.itis.group501.klinov.entites.User;
import ru.kpfu.itis.group501.klinov.helpers.Hash;
import ru.kpfu.itis.group501.klinov.helpers.Helper;
import ru.kpfu.itis.group501.klinov.helpers.Token;
import ru.kpfu.itis.group501.klinov.services.TokenService;
import ru.kpfu.itis.group501.klinov.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {

    public void init() throws ServletException {}

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login").toLowerCase();
        String password = req.getParameter("password");
        String remember = "";
        if (req.getParameter("switch") != null)
            remember = "on";
        System.out.println(remember);

        UserService userService = new UserService();
        User currentUser = userService.find(login);

        if (currentUser != null) {
            if (Hash.getMd5Apache(password).equals(currentUser.getPassword())) {

                req.getSession().setAttribute("current_user", currentUser);
                if (remember.equals("on")){
                    String token = Token.getToken();
                    Cookie cookie = new Cookie("current_user", token);
                    cookie.setMaxAge(30 * 24 * 60 * 60);
                    resp.addCookie(cookie);
                    TokenService ts = new TokenService();
                    ts.addToken(currentUser.getId(), token);
                }

                resp.sendRedirect("/home");

            } else {
                resp.sendRedirect("/login?err=Wrong password&login=" + login);
            }
        } else {
            resp.sendRedirect("/login?err="+userService.getError().getMessage());
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> root = new HashMap<>();

        root.put("err", request.getParameter("err"));
        root.put("login", request.getParameter("login"));

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Helper.render(request,response,"login.ftl",(HashMap) root);

    }

}