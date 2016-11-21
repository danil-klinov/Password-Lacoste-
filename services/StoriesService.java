package ru.kpfu.itis.group501.klinov.services;

import ru.kpfu.itis.group501.klinov.dao.StoriesDao;
import ru.kpfu.itis.group501.klinov.entites.Stories;
import ru.kpfu.itis.group501.klinov.helpers.MyError;

import java.util.List;

/**
 * Created by Даниил on 09.11.2016.
 */
public class StoriesService implements StoriesServiceInterface {

    private StoriesDao storiesDao = null;
    private MyError error = null;

    public StoriesService() {
        this.storiesDao = new StoriesDao();
    }

    public List<Stories> getAllStories(){
        error = null;
        if (storiesDao.getAllStories().equals(null)) {
            error = new MyError("Story_not_found", "Story_not_found");
            return null;
        } else {
            return storiesDao.getAllStories();
        }
    }

    public Stories getStory(int id){
        error = null;
        if (storiesDao.getStory(id).equals(null)) {
            error = new MyError("Story_not_found", "Story_not_found");
            return null;
        } else {
            return storiesDao.getStory(id);
        }
    }

    public List<Stories> getAll(int id_user){
        error = null;
        if (storiesDao.getAll(id_user).equals(null)) {
            error = new MyError("Story_not_found", "Story_not_found");
            return null;
        } else {
            return storiesDao.getAll(id_user);
        }
    }

    public List<Stories> getTop(){
        error = null;
        if (storiesDao.getTop().equals(null)) {
            error = new MyError("Story_not_found", "Story_not_found");
            return null;
        } else {
            return storiesDao.getTop();
        }
    }

}
