package ru.kpfu.itis.group501.klinov.entites;

/**
 * Created by Даниил on 08.11.2016.
 */
public class Comment_stories {

    private String id;
    private String user_id;
    private String story_id;
    private String text;
    private String date;

    public Comment_stories(String user_id, String story_id, String text,String date) {
        this(null,user_id,story_id,text,date);
    }
    public Comment_stories(String id,String user_id, String story_id, String text,String date) {
        this.id = id;
        this.user_id = user_id;
        this.story_id = story_id;
        this.text = text;
        this.date = date;
    }

    public  String getId(){ return id;}

    public String getUser_id() {
        return user_id;
    }

    public String getStory_id() {
        return story_id;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

}
