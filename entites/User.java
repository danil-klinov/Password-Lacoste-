package ru.kpfu.itis.group501.klinov.entites;

import java.util.List;

public class User {
    private String id;
    private String name;
    private String login;
    private String password;
    private String email;
    private String town;
    private String about;
    private boolean is_admin;


    public User(String name, String login, String password,String email,String town, String about) {
        this(null,name,login,password,email,town,about);
    }
    public User(String id,String name, String login, String password,String email,String town, String about) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.town = town;
        this.about = about;
        this.is_admin = false;
    }

    public User(String id,String name, String login, String password,String email,String town, String about, boolean is_admin) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.town = town;
        this.about = about;
        this.is_admin = is_admin;
    }
    public String getTown() {
        return town;
    }

    public String getAbout() {
        return about;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getIs_admin() {
        return is_admin;
    }

    public String getLogin() {
        return login;
    }


}