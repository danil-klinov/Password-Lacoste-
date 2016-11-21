package ru.kpfu.itis.group501.klinov.entites;

/**
 * Created by Даниил on 08.11.2016.
 */
public class Photos {

    private String id;
    private String photo;

    public Photos(String photo) {
        this (null, photo);
    }

    public Photos(String id,String photo) {
        this.id = id;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public String getId() {
        return id;
    }


}
