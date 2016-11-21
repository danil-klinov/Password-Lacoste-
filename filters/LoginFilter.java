package ru.kpfu.itis.group501.klinov.filters;

import ru.kpfu.itis.group501.klinov.helpers.CookieToSession;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        if (CookieToSession.add(request) != null) {
            ((HttpServletRequest) request).getSession().setAttribute("current_user", CookieToSession.add(request));
        }

        if (((HttpServletRequest)request).getSession().getAttribute("current_user") != null){
            ((HttpServletResponse)response).sendRedirect("/home");
        }
        else
            chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

