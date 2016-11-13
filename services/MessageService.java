package ru.kpfu.itis.group501.klinov.services;

import ru.kpfu.itis.group501.klinov.dao.MessageDao;
import ru.kpfu.itis.group501.klinov.dao.StoriesDao;
import ru.kpfu.itis.group501.klinov.entites.Message;
import ru.kpfu.itis.group501.klinov.entites.Stories;
import ru.kpfu.itis.group501.klinov.entites.User;
import ru.kpfu.itis.group501.klinov.helpers.Hash;
import ru.kpfu.itis.group501.klinov.helpers.MyError;
import ru.kpfu.itis.group501.klinov.helpers.RegEx;

import java.util.List;

/**
 * Created by Даниил on 13.11.2016.
 */
public class MessageService implements MessageServiceInterface {

    private MessageDao messageDao = null;
    private MyError error = null;

    public MessageService() {
        this.messageDao = new MessageDao();
    }

    public void add(String forum_topic_id, String user_id, String text) {
        Message newMessage = new Message(forum_topic_id,user_id, text, "дата");
        messageDao.addMessage(newMessage);

    }


    public List<Message> getAllMessages(String topic_id){
        error = null;
        if (messageDao.getAllMessages(topic_id).equals(null)) {
            error = new MyError("messages_not_found", "messages_not_found");
            return null;
        } else {
            return messageDao.getAllMessages(topic_id);
        }
    }

}
