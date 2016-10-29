package ru.kpfu.itis.group501.klinov.servlets;

import ru.kpfu.itis.group501.klinov.entites.Message;
import ru.kpfu.itis.group501.klinov.entites.User;
import ru.kpfu.itis.group501.klinov.helpers.Date2;
import ru.kpfu.itis.group501.klinov.helpers.Helper;
import ru.kpfu.itis.group501.klinov.services.ForumService;
import ru.kpfu.itis.group501.klinov.services.MessageService;
import ru.kpfu.itis.group501.klinov.services.UserService;
import ru.kpfu.itis.group501.klinov.services.UserServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Даниил on 13.11.2016.
 */
public class ForumTopicServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String topic = request.getParameter("topic");
        String text = request.getParameter("text");
        String name = request.getParameter("name");
        int number = Integer.parseInt(request.getParameter("number"));

        User user = (User) request.getSession().getAttribute("current_user");

        MessageService ms = new MessageService();

        ms.add(topic,user.getId(),text);

        response.sendRedirect("/forum_topic?topic=" + topic + "&name=" + name + "&number=" + number);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> root = new HashMap<>();
        String topic = request.getParameter("topic");
        String name = request.getParameter("name");
        int number = Integer.parseInt(request.getParameter("number"));

        MessageService ms = new MessageService();

        List<Message> mes = ms.getAllMessages(topic);

        int i =  (mes.size() / 10) + 1 ;

        List<Message> mespage = new ArrayList<>();

        for (int q = number * 10 - 10; q < number * 10; q++){
            if (q == mes.size())
                break;
            mespage.add(mes.get(q));
        }

        User user = (User) request.getSession().getAttribute("current_user");

        if (user != null)
            root.put("avto", "yes");
        else
            root.put("avto", "no");


        root.put("messages",mespage);
        root.put("topic", topic);
        root.put("name", name);
        root.put("number",number);
        root.put("max", i);

        List<Integer> page = new ArrayList<>();
        for (int q = 1; q <= i; q++)
            page.add(q);

        root.put("page", page);

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Helper.render(request,response,"forum_topic.ftl",(HashMap) root);

    }

}
