package ru.kpfu.itis.group501.klinov.servlets;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.kpfu.itis.group501.klinov.configs.BdSingleton;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Даниил on 09.11.2016.
 */
public class SearchServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String q = request.getParameter("search-input");
        String column = request.getParameter("column");
        String table = request.getParameter("table");
        if (q != null) {
            try {
                PreparedStatement st = BdSingleton.getConnection().prepareStatement(
                        "select " + column + " from " + table + " where " + column + " LIKE ?"
                );
                st.setString(1, "%" + q + "%");
                ResultSet rs = st.executeQuery();
                JSONArray ja = new JSONArray();
                while (rs.next()) {
                    ja.put(rs.getString(column));
                }
                JSONObject jo = new JSONObject();
                jo.put("result", ja);
                response.setContentType("text/json");
                response.getWriter().println(jo.toString());

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}