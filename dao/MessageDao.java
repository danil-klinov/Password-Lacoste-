package ru.kpfu.itis.group501.klinov.dao;

import ru.kpfu.itis.group501.klinov.configs.BdSingleton;
import ru.kpfu.itis.group501.klinov.entites.Message;
import ru.kpfu.itis.group501.klinov.entites.Stories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created by Даниил on 13.11.2016.
 */
public class MessageDao implements MessageDaoInterface {


    public void addMessage(Message message) {
        if (BdSingleton.getConnection() != null && message != null) {
            String request = "INSERT INTO message (forum_topic_id, user_id,text,date) VALUES (?,?,?,?)";

            try {
                PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
                st.setInt(1,Integer.parseInt(message.getForum_topic_id()));
                st.setInt(2,Integer.parseInt(message.getUser_name()));
                st.setString(3,message.getText());
                st.setTimestamp(4,new Timestamp(new Date().getTime()));
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public List<Message> getAllMessages(String topic_id){
        if (BdSingleton.getConnection()!= null && !topic_id.equals("")){
            String request = ("SELECT message.id as id, forum_topic_id, name, text, date  FROM users join message on users.id = message.user_id where forum_topic_id = " + topic_id);
                try {
                    PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
                    ResultSet resultSet = st.executeQuery();
                    List<Message> a = new ArrayList<>();
                    while (resultSet.next()) {
                        a.add(new Message(resultSet.getString("id"), resultSet.getString("forum_topic_id"),resultSet.getString("name"), resultSet.getString("text"),resultSet.getString("date")));
                    }
                    return a;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
        return null;
    }

}
