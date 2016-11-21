package ru.kpfu.itis.group501.klinov.dao;

import ru.kpfu.itis.group501.klinov.configs.BdSingleton;
import ru.kpfu.itis.group501.klinov.helpers.DeleteFromBD;
import ru.kpfu.itis.group501.klinov.helpers.DeleteFromBDForToken;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TokenDao implements  TokenDaoInterface {

    public void addToken(String id, String token) {

        if (BdSingleton.getConnection() != null && !id.equals("") && !token.equals("")) {
            String request = "INSERT INTO cookies (id,token) VALUES ( ? , ? )";
            try {
                PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
                st = BdSingleton.getConnection().prepareStatement(request);
                st.setString(1,id);
                st.setString(2,token);
                st.executeUpdate();
                st.close();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }

    }

    public void updateToken(String id, String token) {
        if (BdSingleton.getConnection() != null && !id.equals("") && !token.equals("")) {
            String request = "UPDATE cookies SET token = ?  WHERE id = ? ";
            try {
                PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
                st = BdSingleton.getConnection().prepareStatement(request);
                st.setString(1,token);
                st.setString(2,id);
                st.executeUpdate();
                st.close();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
    }

    public void deleteToken(String token) {
        String request = "DELETE FROM cookies WHERE token = ? ";
        DeleteFromBDForToken d = new DeleteFromBDForToken();
        d.delete(request,token);
    }

    public String findToken(String token) {
        if (BdSingleton.getConnection() != null && !token.equals("")) {
            String request = "SELECT * FROM cookies " +
                    "WHERE token= ? ";
            try {
                PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
                st.setString(1,token);
                ResultSet resultSet = st.executeQuery();
                while (resultSet.next()) {
                    return resultSet.getString("id");
                }
                st.close();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return null;
    }

}