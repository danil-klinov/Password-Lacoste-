package ru.kpfu.itis.group501.klinov.dao;

import ru.kpfu.itis.group501.klinov.configs.BdSingleton;
import ru.kpfu.itis.group501.klinov.entites.User;
import ru.kpfu.itis.group501.klinov.helpers.DeleteFromBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserDaoInterface {

    public void addUser(User user) {
        if (BdSingleton.getConnection() != null && user != null) {
            String request = "INSERT INTO users (name,login, password,email,town,about) VALUES (?,?,?,?,?,?)";

            try {
                PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
                st.setString(1,user.getName());
                st.setString(2,user.getLogin());
                st.setString(3,user.getPassword());
                st.setString(4,user.getEmail());
                st.setString(5,user.getTown());
                st.setString(6,user.getAbout());
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public User findUser(String login) {
        if (BdSingleton.getConnection()!= null && !login.equals("")) {
            String request = "SELECT * FROM users WHERE login= ? ";
            try {
                PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
                st.setString(1,login);
                ResultSet resultSet = st.executeQuery();
                while (resultSet.next()) {
                    return new User(resultSet.getString("id"),resultSet.getString("name"),
                            resultSet.getString("login"), resultSet.getString("password"), resultSet.getString("email"),resultSet.getString("town"),resultSet.getString("about"), resultSet.getBoolean("is_admin"));
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
            return null;
        }
        return null;
    }

    public User findUserId(String id) {
        if (BdSingleton.getConnection()!= null && !id.equals("")) {
            String request = "SELECT * FROM users WHERE id= ? ";
            try {
                PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
                st.setInt(1,Integer.parseInt(id));
                ResultSet resultSet = st.executeQuery();
                while (resultSet.next()) {
                    return new User(resultSet.getString("id"),resultSet.getString("name"),
                            resultSet.getString("login"), resultSet.getString("password"), resultSet.getString("email"),resultSet.getString("town"),resultSet.getString("about"));
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
            return null;
        }
        return null;
    }

    public List<User> getAllUsers(){
        String request = ("SELECT * FROM users");
        try {
            PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
            ResultSet resultSet = st.executeQuery();
            List<User> a = new ArrayList<>();
            while (resultSet.next()) {
                a.add(new User(resultSet.getString("id"),resultSet.getString("name"), resultSet.getString("login"),resultSet.getString("password"),resultSet.getString("email"),resultSet.getString("town"),resultSet.getString("about")));
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getSearchUsers(String text){
        String request = ("SELECT * FROM users where name like " + text + " or login like " + text + " or email like " + text + " or town like " + text + " or password like " + text + " or about like " + text);
        try {
            PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
            ResultSet resultSet = st.executeQuery();
            List<User> a = new ArrayList<>();
            while (resultSet.next()) {
                a.add(new User(resultSet.getString("id"),resultSet.getString("name"), resultSet.getString("login"),resultSet.getString("password"),resultSet.getString("email"),resultSet.getString("town"),resultSet.getString("about")));
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void deleteUser(String id) {
        String request = "DELETE FROM users WHERE id = ? ";
        DeleteFromBD d = new DeleteFromBD();
        d.delete(request,id);
    }


}
