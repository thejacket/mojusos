package com.thejacket;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mariusz on 2017-04-23.
 */
public class UsosSQLConnector {

    Connection connection = null;

    public void connect() {

        String url = "jdbc:mysql://db4free.net:3306/mojusosdb";
        String user = "mojusosdb";
        String password = "ppa2017";

        try {
            this.connection = DriverManager.getConnection(url, user, password);     // connecting to db

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(SQLTest.class.getName());     // logging in terminal
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    }

    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException exc) {

            Logger lgr = Logger.getLogger(SQLTest.class.getName());
            lgr.log(Level.WARNING, exc.getMessage(), exc);
        }
    }

    public ResultSet sendUsosQuery(String query){
        Statement st = null;
        ResultSet rs = null;

        try {
            st = this.connection.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException exc) {
            Logger lgr = Logger.getLogger(SQLTest.class.getName());
            lgr.log(Level.WARNING, exc.getMessage(), exc);
        }
        return rs;
    }

    public void updateUsos(String s){

    }
}
