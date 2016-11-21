package ru.kpfu.itis.group501.klinov.helpers;

import ru.kpfu.itis.group501.klinov.entites.User;
import ru.kpfu.itis.group501.klinov.services.TokenService;
import ru.kpfu.itis.group501.klinov.services.TokenServiceInterface;
import ru.kpfu.itis.group501.klinov.services.UserService;
import ru.kpfu.itis.group501.klinov.services.UserServiceInterface;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieToSession {
    public static User add(ServletRequest req){
        Cookie[] cookies = ((HttpServletRequest) req).getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("current_user")) {

                    TokenServiceInterface tokenService = new TokenService();
                    String id = tokenService.findToken(cookie.getValue());
                    UserServiceInterface userService = new UserService();
                    return userService.findId(id);

                }
            }
        }
        return null;
    }

}
