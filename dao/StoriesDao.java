package ru.kpfu.itis.group501.klinov.dao;

import ru.kpfu.itis.group501.klinov.configs.BdSingleton;
import ru.kpfu.itis.group501.klinov.entites.Stories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Даниил on 09.11.2016.
 */
public class StoriesDao implements StoriesDaoInterface{

    public List<Stories> getAllStories(){
        String request = ("SELECT * FROM stories");
        try {
            PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
            ResultSet resultSet = st.executeQuery();
            List<Stories> a = new ArrayList<>();
            while (resultSet.next()) {
                a.add(new Stories(resultSet.getString("id"), resultSet.getString("story"),resultSet.getString("photo"), resultSet.getString("country"),resultSet.getString("time"), resultSet.getString("shortstory"), resultSet.getString("name")));
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Stories getStory(int id){
        String request = ("SELECT * FROM stories WHERE id = ?");
        try {
            PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
            st.setInt(1,id);
            ResultSet resultSet = st.executeQuery();
            resultSet.next();
            Stories a = new Stories(resultSet.getString("id"), resultSet.getString("story"),resultSet.getString("photo"), resultSet.getString("country"),resultSet.getString("time"), resultSet.getString("shortstory"), resultSet.getString("name"));
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Stories> getAll(int id_user){
        String request = ("SELECT * FROM stories where id in (SELECT story_id from favorites where user_id = " + id_user + ")");
        try {
            PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
            ResultSet resultSet = st.executeQuery();
            List<Stories> a = new ArrayList<>();
            while (resultSet.next()) {
                a.add(new Stories(resultSet.getString("id"), resultSet.getString("story"),resultSet.getString("photo"), resultSet.getString("country"),resultSet.getString("time"), resultSet.getString("shortstory"), resultSet.getString("name")));
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Stories> getTop(){
        String request = ("select id, name, story, photo, country, time, shortstory from stories join favorites on stories.id = favorites.story_id group by story_id, stories.id order by count(user_id) desc");
        try {
            PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
            ResultSet resultSet = st.executeQuery();
            List<Stories> a = new ArrayList<>();
            int i = 1;
            while (resultSet.next() && i < 6) {
                a.add(new Stories(resultSet.getString("id"), resultSet.getString("story"),resultSet.getString("photo"), resultSet.getString("country"),Integer.toString(i), resultSet.getString("shortstory"), resultSet.getString("name")));
                i++;
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
