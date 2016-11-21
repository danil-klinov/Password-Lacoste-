package ru.kpfu.itis.group501.klinov.services;

import java.util.List;

/**
 * Created by Даниил on 13.11.2016.
 */
public interface ForumServiceInterface {

    List getAllTopics();
    void add(String name, String user_id);

}
