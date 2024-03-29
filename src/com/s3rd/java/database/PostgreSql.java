package com.s3rd.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSql {
    private DatabaseConfiguration config;
    public Connection connection;
    public Statement statement;

    public PostgreSql() {
        this.config = new DatabaseConfiguration();
    }

    public Connection connect() throws SQLException {
        this.connection = DriverManager.getConnection(
                this.config.toString(),
                this.config.username,
                this.config.password);
        return this.connection;
    }
}
