package ru.kpfu.itis.group501.klinov.dao;

import ru.kpfu.itis.group501.klinov.entites.Forum_topic;
import ru.kpfu.itis.group501.klinov.entites.User;

import java.util.List;

/**
 * Created by Даниил on 13.11.2016.
 */
public interface ForumDaoInterface {

    List getAllTopics();
    void addTopic(Forum_topic forum_topic);

}
