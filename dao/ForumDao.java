package ru.kpfu.itis.group501.klinov.dao;

import ru.kpfu.itis.group501.klinov.configs.BdSingleton;
import ru.kpfu.itis.group501.klinov.entites.Forum_topic;
import ru.kpfu.itis.group501.klinov.entites.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Даниил on 13.11.2016.
 */
public class ForumDao implements ForumDaoInterface{

    public List<Forum_topic> getAllTopics(){

        String request = ("SELECT * FROM forum_topic");
        try {
            PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
            ResultSet resultSet = st.executeQuery();
            List<Forum_topic> a = new ArrayList<>();
            while (resultSet.next()) {
                a.add(new Forum_topic(resultSet.getString("id"),resultSet.getString("name"), resultSet.getString("users_id"),resultSet.getString("date")));
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addTopic(Forum_topic forum_topic) {
        if (BdSingleton.getConnection() != null && forum_topic != null) {
            String request = "INSERT INTO forum_topic (name, users_id, date) VALUES (?,?,?)";

            try {
                PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
                st.setString(1,forum_topic.getName());
                st.setInt(2,Integer.parseInt(forum_topic.getUser_id()));
                st.setTimestamp(3,new Timestamp(new Date().getTime()));
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
