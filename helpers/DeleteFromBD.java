package ru.kpfu.itis.group501.klinov.helpers;

import ru.kpfu.itis.group501.klinov.configs.BdSingleton;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteFromBD {

    public void delete (String request,String parametr){

        if (BdSingleton.getConnection() != null && !parametr.equals("")) {

            try {

                PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
                st= BdSingleton.getConnection().prepareStatement(request);
                st.setInt(1, Integer.parseInt(parametr));
                st.executeUpdate();
                st.close();

            } catch (SQLException sql) {

                sql.printStackTrace();

            }

        }

    }

}
