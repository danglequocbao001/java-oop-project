package com.s3rd.java.models;

import com.s3rd.java.database.PostgreSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Book {
    PostgreSql connector;

    public Book(PostgreSql connector) {
        super();
        this.connector = connector;
    }

    String GET_ALL = "SELECT * FROM books ORDER BY id";
    String CREATE_ONE = ( "INSERT INTO books " +
                          "       (name, position, status, created_at, updated_at) " +
                          "VALUES (?   , ?       , ?     , NOW()     , NOW())" );

    String UPDATE_ONE = ( "UPDATE books " +
                          "SET name = ? , " +
                          "    position = ?, " +
                          "    status = ? , " +
                          "    updated_at = NOW() WHERE id = ?" );

    String DELETE_ONE = "DELETE FROM books WHERE id = ?";

    public Response getAll() {
        ArrayList<String[]> records = new ArrayList<String[]>();

        try {
            this.connector.statement = this.connector.connection.createStatement();
            ResultSet rs = this.connector.statement.executeQuery(GET_ALL);

            Integer index = 0;
            while (rs.next()) {
                records.add(new String[] {
                    Integer.toString(rs.getInt("id")),
                    rs.getString("name"),
                    rs.getString("position"),
                    rs.getString("status"),
                });
                index += 1;
            }
            rs.close();
            this.connector.statement.close();

        } catch (Exception e) {
            System.out.println("{Book#getAll}" + e);
        }

        String[][] results = new String[records.size()][];
        records.toArray(results);

        return new Response(results);
    }

    public Response createOne(String name, String position, String status) {
        String id = null;
        try {
            PreparedStatement statement = this.connector.connection.prepareStatement(CREATE_ONE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setString(2, position);
            statement.setString(3, status);
            statement.executeUpdate();

            try {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next())
                id = String.valueOf(generatedKeys.getLong(1));
            } catch (Exception exception1) {
                System.out.println("{Book#createOne}" + exception1);
            }

        } catch (Exception exception2) {
                System.out.println("{Book#createOne}" + exception2);
        }
        return new Response(id);
    }

    public Response updateOne(String id, String name, String position, String status) {
        try {
            PreparedStatement statement = this.connector.connection.prepareStatement(UPDATE_ONE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setString(2, position);
            statement.setString(3, status);
            statement.setLong(4, Long.parseLong(id));
            statement.executeUpdate();

        } catch (Exception exception2) {
                System.out.println("{Book#updateOne}" + exception2);
        }

        return new Response(id);
    }

    public Response deleteOne(String id) {
        try {
            PreparedStatement statement = this.connector.connection.prepareStatement(DELETE_ONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, Long.parseLong(id));
            statement.executeUpdate();

        } catch (Exception exception2) {
                System.out.println("{Book#deleteOne}" + exception2);
        }

        return new Response(id);
    }

    public static void main(String[] a) {
        PostgreSql postgresql = new PostgreSql();
        Book book = new Book(postgresql);

        try {
            postgresql.connect();
        } catch (Exception e) {
            System.out.println("{Book#main}" + e);
        }


        // list all
        String[][] result = (String[][]) book.getAll().data;
        for (String[] ele: result) {
            System.out.println(String.join("-", ele));
        }

        String id;
        // create one
        id = (String) book.createOne("9", "9", "9").data;
        System.out.println(id);

        // update one
        id = (String) book.updateOne(id, "9", "9", "9").data;
        System.out.println(id);

        id = (String) book.deleteOne(id).data;
        System.out.println(id);
    }
}
