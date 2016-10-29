package ru.kpfu.itis.group501.klinov.services;

import ru.kpfu.itis.group501.klinov.dao.UserDao;
import ru.kpfu.itis.group501.klinov.entites.User;
import ru.kpfu.itis.group501.klinov.helpers.Hash;
import ru.kpfu.itis.group501.klinov.helpers.MyError;
import ru.kpfu.itis.group501.klinov.helpers.RegEx;

import java.util.List;

public class UserService implements UserServiceInterface {
    private UserDao userDao = null;
    private MyError error = null;

    public UserService() {
        this.userDao = new UserDao();
    }

    public void add(String name, String login, String password,String passwordAgain, String email, String town, String about) {
        error = null;
        RegEx re = new RegEx();
        if (re.IsRight(name) && re.IsRight(login) && re.IsRight(password) && re.IsRight(passwordAgain)){
            if (password.equals(passwordAgain)) {
                password = Hash.getMd5Apache(password);
                User newUser = new User(name,login, password,email,town,about);
                if (userDao.findUser( login) == null) {
                    userDao.addUser(newUser);
                }
                else{
                    error = new MyError("user_exist", "user_exist");
                }

            } else {
                error = new MyError("wrong_password", "Passwords do not match");
            }
        }else{
            error = new MyError("wrong_words", "wrong_words");
        }
    }


    public void delete(String id) {
        error = null;
        if (userDao.findUserId(id)!=null)
            userDao.deleteUser(id);
        else {
            error = new MyError("user_not_found", "user_not_found");
        }
    }

    public User find(String login) {
        error = null;
        User user = null;
        user = userDao.findUser(login);
        if (user == null) {
            error = new MyError("user_not_found", "user_not_found");
            return null;
        } else {
            return user;
        }
    }

    public User findId(String id) {
        error = null;
        if (userDao.findUserId(id).equals(null)) {
            error = new MyError("user_not_found", "user_not_found");
            return null;
        } else {
            return userDao.findUserId(id);
        }
    }

    public List<User> getAllUsers(){
        error = null;
        if (userDao.getAllUsers().equals(null)) {
            error = new MyError("user_not_found", "user_not_found");
            return null;
        } else {
            return userDao.getAllUsers();
        }
    }

    public List<User> getSearchUsers(String text){
        error = null;
        if (userDao.getSearchUsers(text).equals(null)){
            error = new MyError("user_not_found", "user_not_found");
            return null;
        }
        else{
            return userDao.getSearchUsers(text);
        }
    }

    public MyError getError(){
        return error;
    }

}