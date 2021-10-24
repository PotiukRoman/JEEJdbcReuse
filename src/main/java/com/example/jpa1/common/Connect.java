package com.example.jpa1.common;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Consumer;

public class Connect {
    private static final String URL = "jdbc:mysql://localhost:3306/test2";
    private static final String USER = "dev";
    private static final String PASSWORD = "poridg1803!!!";

    public static void doTransaction(Consumer<java.sql.Connection> consumer) {
        try (java.sql.Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            con.setAutoCommit(false);
            consumer.accept(con);
            con.setAutoCommit(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
