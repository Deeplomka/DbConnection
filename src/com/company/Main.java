package com.company;

import com.company.data.MySqlDB;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.LocomotiveRepo;
import com.company.repositories.TrainRepo;
import com.company.repositories.UserRepository;
import com.company.repositories.interfaces.ILocomotiveRepo;
import com.company.repositories.interfaces.ITrainRepo;
import com.company.repositories.interfaces.IUserRepository;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        String connectionUrl = "jdbc:postgresql://localhost:5432/simpledb";
//        Connection con = null;
//        ResultSet rs = null;
//        Statement stmt = null;
//        try {
//            // Here we load the driver’s class file into memory at the runtime
//            Class.forName("org.postgresql.Driver");
//
//            // Establish the connection
//            con = DriverManager.getConnection(connectionUrl, "postgres", "0000");
//
//            // The object of statement is responsible to execute queries with the database
//            stmt = con.createStatement();
//
//            // The executeQuery() method of Statement interface is used to execute queries
//            // to the database. This method returns the object of ResultSet that can be
//            // used to get all the records of a table that matches the sql statement
//            rs = stmt.executeQuery("select * mistake from users");
//
//            while (rs.next()) // Processing the result
//                System.out.println(rs.getInt("id") + "  "
//                        + rs.getString("name") + "  " + rs.getString("surname"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            try { // Close connection - clean up the system resources
//                rs.close();
//                stmt.close();
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        // Here you specify which DB and UserRepository to use
        // And changing DB should not affect to whole code
        IDB db = new PostgresDB();
//        IUserRepository repo = new UserRepository(db);
//        MyApplication app = new MyApplication(repo);
        ITrainRepo trainRepo = new TrainRepo(db);
        ILocomotiveRepo locomotiveRepo = new LocomotiveRepo(db);
        TrainFrontEnd app = new TrainFrontEnd(trainRepo, locomotiveRepo);
        app.start();
    }
}