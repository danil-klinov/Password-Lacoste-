package ru.kpfu.itis.group501.klinov.services;

import ru.kpfu.itis.group501.klinov.dao.FavoritesDao;
import ru.kpfu.itis.group501.klinov.entites.Favorites;
import ru.kpfu.itis.group501.klinov.helpers.MyError;

import java.util.List;

/**
 * Created by Даниил on 17.11.2016.
 */
public class FavoritesService {

    private FavoritesDao favoritesDao = null;
    private MyError error = null;

    public FavoritesService() {
        this.favoritesDao = new FavoritesDao();
    }

    public void add(String user_id, String story_id) {
        Favorites newF = new Favorites(user_id, story_id);
        favoritesDao.add(newF);
    }

    public List<Favorites> getAll(){
        error = null;
        if (favoritesDao.getAll().equals(null)) {
            error = new MyError("favorites_not_found", "favorites not found");
            return null;
        } else {
            return favoritesDao.getAll();
        }
    }


    public void delete(String user_id, String story_id) {
        error = null;
        Favorites newF = new Favorites(user_id, story_id);
        favoritesDao.delete(newF);
    }

}
