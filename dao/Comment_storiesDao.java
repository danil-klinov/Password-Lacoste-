package ru.kpfu.itis.group501.klinov.dao;

import ru.kpfu.itis.group501.klinov.configs.BdSingleton;
import ru.kpfu.itis.group501.klinov.entites.Comment_stories;
import ru.kpfu.itis.group501.klinov.entites.Message;
import ru.kpfu.itis.group501.klinov.entites.User;
import ru.kpfu.itis.group501.klinov.services.UserService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Даниил on 09.11.2016.
 */
public class Comment_storiesDao implements Comment_storiesDaoInterface{

    public List<Comment_stories> getAllComment(){
        String request = ("SELECT * FROM comment_stories");
        try {
            PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
            ResultSet resultSet = st.executeQuery();
            List<Comment_stories> a = new ArrayList<>();
            while (resultSet.next()) {
                UserService userService = new UserService();
                User user = userService.findId(resultSet.getString("user_id"));
                a.add(new Comment_stories(resultSet.getString("id"), user.getName(),resultSet.getString("story_id"), resultSet.getString("text"),resultSet.getString("date")));
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addComment(Comment_stories comment) {
        if (BdSingleton.getConnection() != null && comment != null) {
            String request = "INSERT INTO comment_stories (user_id, story_id,text,date) VALUES (?,?,?,?)";

            try {
                PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
                st.setInt(1,Integer.parseInt(comment.getUser_id()));
                st.setInt(2,Integer.parseInt(comment.getStory_id()));
                st.setString(3,comment.getText());
                st.setTimestamp(4,new Timestamp(new Date().getTime()));
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
