package ru.kpfu.itis.group501.klinov.dao;

import ru.kpfu.itis.group501.klinov.configs.BdSingleton;
import ru.kpfu.itis.group501.klinov.entites.Favorites;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Даниил on 17.11.2016.
 */
public class FavoritesDao {

    public void add(Favorites favorites) {
        if (BdSingleton.getConnection() != null && favorites != null) {
            String request = "INSERT INTO favorites (user_id, story_id) VALUES (?,?)";

            try {
                PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
                st.setInt(1,Integer.parseInt(favorites.getUser_id()));
                st.setInt(2,Integer.parseInt(favorites.getStory_id()));
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Favorites> getAll(){

        String request = ("SELECT * FROM favorites");
        try {
            PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
            ResultSet resultSet = st.executeQuery();
            List<Favorites> a = new ArrayList<>();
            while (resultSet.next()) {
                a.add(new Favorites(resultSet.getString("user_id"),resultSet.getString("story_id")));
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(Favorites favorites){

        String request = "DELETE FROM favorites WHERE user_id = ? and story_id = ? ";

        try {
            PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
            st.setInt(1,Integer.parseInt(favorites.getUser_id()));
            st.setInt(2,Integer.parseInt(favorites.getStory_id()));
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
