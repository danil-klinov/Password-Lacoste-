package ru.kpfu.itis.group501.klinov.dao;

import ru.kpfu.itis.group501.klinov.entites.Message;

import java.util.List;

/**
 * Created by Даниил on 13.11.2016.
 */
public interface MessageDaoInterface {

    List getAllMessages(String topic_id);
    void addMessage (Message message);

}
