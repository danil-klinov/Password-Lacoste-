package ru.kpfu.itis.group501.klinov.helpers;

import java.security.SecureRandom;

public class Token {
    private String string = null;

    public static String getToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();
        return token;
    }



}