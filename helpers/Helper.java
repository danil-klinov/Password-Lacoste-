package ru.kpfu.itis.group501.klinov.helpers;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import ru.kpfu.itis.group501.klinov.configs.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


public class Helper {


    public static void render(HttpServletRequest request, HttpServletResponse response, String s, HashMap root) throws ServletException, IOException

    {
        Configuration cfg = Singleton.getConfig(request.getServletContext());
        Template tmpl = cfg.getTemplate(s);

        try {
            tmpl.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }


}
