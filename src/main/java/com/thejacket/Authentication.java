package com.thejacket;

/**
 * Created by mariusz on 2017-05-07.
 */
public class Authentication {

    private static String authenticatedLogin;
    private static String authenticatedPw;

    public static String getAuthenticatedLogin() {
        return authenticatedLogin;
    }

    public static String getAuthenticatedPw() {
        return authenticatedPw;
    }

    public static void setAuthenticatedLogin(String s) {
        authenticatedLogin = s;
    }

    public static void setAuthenticatedPw(String s) {
        authenticatedPw = s;
    }
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
