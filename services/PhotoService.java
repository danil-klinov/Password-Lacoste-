package ru.kpfu.itis.group501.klinov.services;

import ru.kpfu.itis.group501.klinov.dao.PhotoDao;
import ru.kpfu.itis.group501.klinov.entites.Photos;
import ru.kpfu.itis.group501.klinov.helpers.MyError;

import java.util.List;

/**
 * Created by Даниил on 16.11.2016.
 */
public class PhotoService {

    private PhotoDao photoDao = null;
    private MyError error = null;

    public PhotoService() { this.photoDao = new PhotoDao(); }

    public List<Photos> getAllPhoto(){
        error = null;
        if (photoDao.getAllPhoto().equals(null)) {
            error = new MyError("photos_not_found", "photos_not_found");
            return null;
        } else {
            return photoDao.getAllPhoto();
        }
    }

}
