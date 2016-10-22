package ru.kpfu.itis.group501.klinov.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public boolean IsRight(String s){
        Pattern data = Pattern.compile("(^[a-z]+)");
        Matcher m = data.matcher(s);
        return m.matches();
    }

}
