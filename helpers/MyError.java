package ru.kpfu.itis.group501.klinov.helpers;

public class MyError {
    private static String name;
    private static String message;

    public MyError(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public static String getName() {
        return name;
    }

    public static String getMessage() {
        return message;
    }
}