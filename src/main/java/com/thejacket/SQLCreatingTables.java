package com.thejacket;

/**
 * Created by mariusz on 2017-04-23.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLCreatingTables {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pst = null;

        String url = "jdbc:mysql://db4free.net:3306/mojusosdb";
        String user = "mojusosdb";
        String password = "ppa2017";

        try {

            String author = "Trygve Gulbranssen";
            con = DriverManager.getConnection(url, user, password);

            pst = con.prepareStatement("CREATE TABLE Testing(Id INT)");
            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(SQLCreatingTables.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {

                if (pst != null) {
                    pst.close();
                }

                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {

                Logger lgr = Logger.getLogger(SQLCreatingTables.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
}