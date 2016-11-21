package ru.kpfu.itis.group501.klinov.services;

import ru.kpfu.itis.group501.klinov.dao.ForumDao;
import ru.kpfu.itis.group501.klinov.dao.UserDao;
import ru.kpfu.itis.group501.klinov.entites.Forum_topic;
import ru.kpfu.itis.group501.klinov.entites.User;
import ru.kpfu.itis.group501.klinov.helpers.MyError;

import java.util.List;

/**
 * Created by Даниил on 13.11.2016.
 */
public class ForumService implements ForumServiceInterface {

    private ForumDao forumDao = null;
    private MyError error = null;

    public ForumService() {
        this.forumDao = new ForumDao();
    }

    public List<Forum_topic> getAllTopics(){
        error = null;
        if (forumDao.getAllTopics().equals(null)) {
            error = new MyError("topics_not_found", "topics_not_found");
            return null;
        } else {
            return forumDao.getAllTopics();
        }
    }

    public void add(String name, String user_id) {
        Forum_topic newForum_topic = new Forum_topic(name,user_id, "дата");
        forumDao.addTopic(newForum_topic);

    }


}
