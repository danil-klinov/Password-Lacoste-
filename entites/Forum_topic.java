package ru.kpfu.itis.group501.klinov.entites;

/**
 * Created by Даниил on 08.11.2016.
 */
public class Forum_topic {

    private String id;
    private String name;
    private String user_id;
    private String date;

    public Forum_topic(String name, String user_id, String date) {
        this(null,name,user_id,date);
    }
    public Forum_topic(String id,String name, String user_id, String date) {
        this.id = id;
        this.name = name;
        this.user_id = user_id;
        this.date = date;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
