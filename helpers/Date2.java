package ru.kpfu.itis.group501.klinov.helpers;

import java.util.Date;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

/**
 * Created by Даниил on 13.11.2016.
 */
public class Date2 {

    public String getDateTime() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Date date = new Date();

        return dateFormat.format(date);

    }

}
