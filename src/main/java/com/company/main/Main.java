package com.company.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void getAllUsers() throws Exception {

        //Deprecated: "com.mysql.jdbc.Driver"
        //Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "";

        Connection c = DriverManager.getConnection(url, username, password);

        Statement stmt = c.createStatement();
        stmt.execute("select * from user");

        ResultSet rs = stmt.getResultSet();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");

            System.out.println("ID = "+id);
            System.out.println("Name = "+name);
            System.out.println("Surname = "+surname);
            System.out.println("E-mail = "+email);
            System.out.println("Phone number = "+phone);

            System.out.println("-------------------");
        }
    }

    public static void updateUser() throws Exception {
        //Deprecated: "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "";
        Connection c = DriverManager.getConnection(url, username, password);
        Statement stmt = c.createStatement();
        stmt.execute("update user set name = 'Mike' where id = 1");
    }

    public static void main(String[] args) throws Exception {
        updateUser();
        getAllUsers();

    }
}