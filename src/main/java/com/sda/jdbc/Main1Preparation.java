package com.sda.jdbc;

import java.sql.*;

import static com.sda.jdbc.Configuration.*;

public class Main1Preparation {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");

        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.printf("Id: %s Name: %s Age: %s\n", id, name, age);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
