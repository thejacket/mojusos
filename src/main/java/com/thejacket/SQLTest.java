package com.thejacket;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mariusz on 2017-04-23.
 */
public class SQLTest {

        public static void main(String[] args) {

            Connection connection = null;
            Statement statementObject = null;
            ResultSet results = null;

            String url = "jdbc:mysql://db4free.net:3306/mojusosdb";
            String user = "mojusosdb";
            String password = "ppa2017";

            try {

                connection = DriverManager.getConnection(url, user, password);     // connecting to db
                statementObject = connection.createStatement();                    // create statement object for sending queries
                statementObject.executeUpdate("DROP TABLE Tabela1");
                statementObject.executeUpdate("CREATE TABLE Tabela1 " +
                        "(" +
                        "id INT NOT NULL AUTO_INCREMENT," +
                        "age INT NOT NULL," +

                        "PRIMARY KEY (id))");
                /*statementObject.executeQuery("SELECT VERSION()");     // send string query, returns single ResultSet object
                statementObject.executeUpdate("DROP TABLE Tabela1");
                statementObject.executeUpdate("CREATE TABLE Tabela1 " +
                        "(" +
                        "id INT NOT NULL AUTO_INCREMENT," +
                        "age INT NOT NULL," +
                        "PRIMARY KEY (id))");
                statementObject.executeUpdate("INSERT INTO Tabela1 (age) VALUES (10),(20),(30)");

                //results = statementObject.executeQuery("SELECT id, age FROM Tabela1");
                */
                //statementObject.executeUpdate("INSERT INTO Tabela1 (id, age) VALUES (102, 10), (4,50)");
                /*
                statementObject.executeUpdate("DELETE FROM Tabela1 WHERE id = 4");

                ResultSet resultSet = statementObject.executeQuery("SELECT id, age FROM Tabela1");
                ResultSetMetaData rsmd = resultSet.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                while (resultSet.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = resultSet.getString(i);
                        System.out.print(columnValue + " " + rsmd.getColumnName(i));
                    }
                    System.out.println("");
                }*/


                /*while (results.next()) {                                          // ResultSet has property of pointing to current row of data
                                                                                 // initially, its positioned before first row
                    System.out.println(results.getString("age"));      // result.next() returns false if there are no rows left

                }*/



            } catch (SQLException ex) {

                Logger lgr = Logger.getLogger(SQLTest.class.getName());     // logging in terminal
                lgr.log(Level.SEVERE, ex.getMessage(), ex);

            } finally {

                try {

                    if (results != null) {                                    // in case of NullPointerException;
                        results.close();
                    }

                    if (statementObject != null) {
                        statementObject.close();
                    }

                    if (connection != null) {
                        connection.close();
                    }

                } catch (SQLException ex) {

                    Logger lgr = Logger.getLogger(SQLTest.class.getName());
                    lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
            }
        }
    }
