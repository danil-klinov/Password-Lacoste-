package ru.kpfu.itis.group501.klinov.helpers;

import ru.kpfu.itis.group501.klinov.configs.BdSingleton;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Даниил on 16.11.2016.
 */
public class UpdeatBD {

    public void updeat (String table, String column, Integer id, String text){

        if (BdSingleton.getConnection() != null && table != null && column != null && id != null && text != null ) {
            String request = "UPDATE " + table + " set " + column + " = " + text + " where id = " + id;
            try {
                PreparedStatement st = BdSingleton.getConnection().prepareStatement(request);
                st.execute();
                st.close();

            } catch (SQLException sql) {

                sql.printStackTrace();

            }
        }

    }

}
