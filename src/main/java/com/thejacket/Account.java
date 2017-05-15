package com.thejacket;

/**
 * Created by mariusz on 2017-04-23.
 */
public class Account {

    private String accountName;
    private String password;

    private boolean rights;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRights(boolean b) {
        this.rights = b;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPassword() {
        return password;
    }

    Account (String name, String password, boolean rights){
        this.accountName = name;
        this.password = password;
        this.rights = rights;
    }

}
