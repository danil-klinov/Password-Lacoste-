package ru.kpfu.itis.group501.klinov.servlets;

import ru.kpfu.itis.group501.klinov.services.TokenService;
import ru.kpfu.itis.group501.klinov.services.TokenServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Даниил on 08.11.2016.
 */
public class LogoutServlet extends HttpServlet {

    TokenService tokenService = new TokenService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie: cookies
                ) {
            if (cookie.getName().equals("current_user")) {
                String current_token = cookie.getValue();
                cookie.setValue("");
                cookie.setMaxAge(0);
                TokenServiceInterface tokenService = new TokenService();
                if (tokenService.findToken(current_token)!=null) {
                    tokenService.deleteToken(current_token);
                }
                response.addCookie(cookie);
            }
        }
        request.getSession().invalidate();
        response.sendRedirect("/login");

    }

}
