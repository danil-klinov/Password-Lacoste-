package ru.kpfu.itis.group501.klinov.entites;

/**
 * Created by Даниил on 08.11.2016.
 */
public class Favorites {

    private String user_id;
    private String story_id;

    public Favorites(String user_id,String story_id) {
        this.user_id = user_id;
        this.story_id = story_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getStory_id() {
        return story_id;
    }

}
