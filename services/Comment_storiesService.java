package ru.kpfu.itis.group501.klinov.services;

import ru.kpfu.itis.group501.klinov.dao.Comment_storiesDao;
import ru.kpfu.itis.group501.klinov.entites.Comment_stories;
import ru.kpfu.itis.group501.klinov.helpers.MyError;

import java.util.List;

/**
 * Created by Даниил on 09.11.2016.
 */
public class Comment_storiesService implements Comment_storiesServiceInterface{

    private Comment_storiesDao commentDao = null;
    private MyError error = null;

    public Comment_storiesService() {
        this.commentDao = new Comment_storiesDao();
    }

    public List<Comment_stories> getAllComment(){
        error = null;
        if (commentDao.getAllComment().equals(null)) {
            error = new MyError("comment_not_found", "Comment not found");
            return null;
        } else {
            return commentDao.getAllComment();
        }
    }

    public void addComment(String user_id, String story_id, String text) {
        Comment_stories newComment = new Comment_stories(user_id, story_id, text, "дата");
        commentDao.addComment(newComment);

    }

}
