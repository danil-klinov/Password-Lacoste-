package ru.kpfu.itis.group501.klinov.dao;

import ru.kpfu.itis.group501.klinov.entites.Favorites;

import java.util.List;

/**
 * Created by Даниил on 17.11.2016.
 */
public interface FavoritesDaoInterface {

    void add(Favorites favorites);
    List getAll();
    void delete(Favorites favorites);

}
