package ru.kpfu.itis.group501.klinov.dao;

public interface TokenDaoInterface {

    void addToken(String id, String token) ;
    void updateToken(String id, String token) ;
    void deleteToken(String token) ;
    String findToken(String token) ;

}
