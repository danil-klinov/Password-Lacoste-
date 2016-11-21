package ru.kpfu.itis.group501.klinov.dao;

import ru.kpfu.itis.group501.klinov.entites.Comment_stories;

import java.util.List;

/**
 * Created by Даниил on 09.11.2016.
 */
public interface Comment_storiesDaoInterface {
    List getAllComment();
    void addComment(Comment_stories comment_stories);
}
