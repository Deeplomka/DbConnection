package com.company.data;

import com.company.data.interfaces.IDB;

import java.sql.*;

public class MySqlDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:mysql://localhost:3306/SimpleDb";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.mysql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "adilkhan", "123");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}