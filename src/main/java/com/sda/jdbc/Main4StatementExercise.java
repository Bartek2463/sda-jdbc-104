package com.sda.jdbc;

import java.sql.*;

import static com.sda.jdbc.Configuration.*;

public class Main4StatementExercise {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        Statement initialStatement = connection.createStatement();
        initialStatement.execute("CREATE TABLE IF NOT EXISTS user(id BIGINT NOT NULL AUTO_INCREMENT," +
                " username VARCHAR(50) UNIQUE," +
                " password VARCHAR(50)," +
                " PRIMARY KEY(id))");
        initialStatement.close();

        Statement insertStatement = connection.createStatement();
        insertStatement.executeUpdate("INSERT INTO user (username, password) VALUES " +
                "('Jan', 'password1')," +
                "('Ala', 'password2')," +
                "('Mikołaj', 'password3')," +
                "('Kasia', 'password4')," +
                "('Ola', 'password5')," +
                "('Michał', 'password6')");
        insertStatement.close();

        Statement queryStatement = connection.createStatement();
        ResultSet resultSet = queryStatement.executeQuery("SELECT username FROM user");
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            System.out.println(username);
        }
        resultSet.close();
        queryStatement.close();

        connection.close();
    }
}
