package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:C:\\Users\\SAMSUNG\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db";  // Altere "suabase" para o nome do seu banco

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}

