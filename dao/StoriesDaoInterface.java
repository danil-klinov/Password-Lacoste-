package ru.kpfu.itis.group501.klinov.dao;

import ru.kpfu.itis.group501.klinov.entites.Stories;

import java.util.List;

/**
 * Created by Даниил on 09.11.2016.
 */
public interface StoriesDaoInterface {
    List getAllStories();
    Stories getStory(int id);
    List getAll(int id);
    List getTop();
}
