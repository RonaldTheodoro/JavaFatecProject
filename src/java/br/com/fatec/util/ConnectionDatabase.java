package br.com.fatec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
    public Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:db.sqlite3");
        } catch (SQLException error) {
            throw new RuntimeException(error);
        } catch (ClassNotFoundException error) {
            throw new RuntimeException(error);
        }
    }
}
