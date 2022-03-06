package com.sda.jdbc;

import java.sql.*;

import static com.sda.jdbc.Configuration.*;

public class Main3Statement {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        Statement updateStatement = connection.createStatement();
        int amount = updateStatement.executeUpdate("UPDATE animal SET name='Jasio' WHERE id = 2"); // UPDATE, INSERT, DELETE
        System.out.println("Amount: " + amount);
        updateStatement.close();

        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM animal"); // SELECT
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            System.out.printf("Id: %s Name: %s Age: %s\n", id, name, age);
        }
        resultSet.close();
        selectStatement.close();

        Statement executeStatement = connection.createStatement();
        boolean hasResult = executeStatement.execute("TRUNCATE TABLE animal"); // CREATE TABLE, ALTER TABLE, TRUNCATE
        System.out.println(hasResult);
        executeStatement.close();

        connection.close();
    }
}
