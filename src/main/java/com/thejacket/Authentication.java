package com.thejacket;

/**
 * Created by mariusz on 2017-05-07.
 */
public class Authentication {

    private String authenticatedLogin;
    private String authenticatedPw;

    public String getAuthenticatedLogin() {
        return authenticatedLogin;
    }
    public String getAuthenticatedPw() {
        return authenticatedPw;
    }
/*
    public boolean checkDbCredentials() {
        boolean dbCheck;

        if (dbCheck == true) {
            return true;
        }
        else {
            return false;
        }
    }*/
    /* 1. wyslij zapytanie do db z otrzymanymi danymi logowania
        -> jesli w odpowiedniej tabeli znajduje się login z daną nazwą, sprawdz czy odpowiada mu haslo
        -> jesli tak, zapisz login, haslo oraz typ uzytkownika (czy superuser) (haslo bedzie potrzebne pozniej do zmiany credentialsow w db)
        -> jesli nie, wyslij bool false
        -> przechowuj w obiekcie Authentication
     */

}
