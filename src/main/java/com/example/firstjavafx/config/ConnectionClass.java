package com.example.firstjavafx.config;
import java.sql.*;

public class ConnectionClass {

    private ConnectionClass(){}

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/curso",
                    "root",
                    "1304200296"
            );
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
