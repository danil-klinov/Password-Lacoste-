package ru.kpfu.itis.group501.klinov.filters;

import ru.kpfu.itis.group501.klinov.helpers.CookieToSession;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        if (CookieToSession.add(req) != null) {
            ((HttpServletRequest) req).getSession().setAttribute("current_user", CookieToSession.add(req));
        }

        if (((HttpServletRequest) req).getSession().getAttribute("current_user") != null) {

            chain.doFilter(req, resp);
            return;

        } else {
            ((HttpServletResponse)resp).sendRedirect("/login");
            return;
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
