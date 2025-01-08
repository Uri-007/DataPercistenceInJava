package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {

    public Connection get_connection() {

        Connection conection = null;
        try {
            conection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/app_messages", "root", "AdminRoot");

        } catch (SQLException e) {
            System.out.println(e);
        }
        return  conection;
    }

}
