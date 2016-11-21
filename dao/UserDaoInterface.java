package ru.kpfu.itis.group501.klinov.dao;

import ru.kpfu.itis.group501.klinov.entites.User;

import java.util.List;

public interface UserDaoInterface {
    void addUser(User user) ;

    User findUser(String login) ;
    User findUserId(String id) ;
    List getAllUsers();
    List getSearchUsers(String text);


    void deleteUser(String id) ;

}
