package ru.kpfu.itis.group501.klinov.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class BdSingleton {

    private static final String URL = "jdbc:postgresql://localhost:5432/fashion";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Danil739";
    private static final String DRIVER = "org.postgresql.Driver";

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null){

            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        return conn;
    }
}
