package ru.kpfu.itis.group501.klinov.entites;

/**
 * Created by Даниил on 08.11.2016.
 */
public class Message {

    private String id;
    private String forum_topic_id;
    private String user_name;
    private String text;
    private String date;

    public Message(String forum_topic_id, String user_name, String text, String date) {
        this(null,forum_topic_id, user_name,text, date);
    }

    public Message(String id, String forum_topic_id, String user_name, String text, String date) {
        this.id = id;
        this.forum_topic_id = forum_topic_id;
        this.user_name = user_name;
        this.text = text;
        this.date = date;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getForum_topic_id() {
        return forum_topic_id;
    }

    public String getText() { return text; }

}
