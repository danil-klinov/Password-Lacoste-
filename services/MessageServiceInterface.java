package ru.kpfu.itis.group501.klinov.services;

import java.util.List;

/**
 * Created by Даниил on 13.11.2016.
 */
public interface MessageServiceInterface {

    List getAllMessages(String topic_id);
    void add(String forum_topic_id, String user_id , String text);

}
