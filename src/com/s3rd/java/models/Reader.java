package com.s3rd.java.models;

import com.s3rd.java.database.PostgreSql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// TODO: Add function query these columns
// SELECT readers.id, readers.first_name, readers.last_name, readers.gender, readers.status, COUNT(borrow_statuses.reader_id) AS borrowed
// FROM readers
// LEFT JOIN borrow_statuses 
// 	ON readers.id = borrow_statuses.reader_id
// GROUP BY borrow_statuses.reader_id, readers.id
// ORDER BY readers.id;

public class Reader {
    PostgreSql connector;
    String GET_ALL = "SELECT * FROM readers ORDER BY id";
    String CREATE_ONE = ( "INSERT INTO readers " +
                          "       (first_name, last_name, gender, status, created_at, updated_at) " +
                          "VALUES (?         , ?        , ?     , ?     , NOW()     , NOW())" );

    String UPDATE_ONE = ( "UPDATE readers " +
                          "SET first_name = ? , " +
                          "    last_name = ?, " +
                          "    gender = ? , " +
                          "    status = ? , " +
                          "    updated_at = NOW() WHERE id = ?" );

    String DELETE_ONE = "DELETE FROM readers WHERE id = ?";

    public Reader(PostgreSql connector) {
        super();
        this.connector = connector;
    }

    public Response getAll() {
        ArrayList<String[]> records = new ArrayList<String[]>();

        try {
            this.connector.statement = this.connector.connection.createStatement();
            ResultSet rs = this.connector.statement.executeQuery(this.GET_ALL);

            Integer index = 0;
            while (rs.next()) {
                records.add(new String[] {
                    Integer.toString(rs.getInt("id")),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("gender"),
                    rs.getString("status"),
                    "1",
                });
                index += 1;
            }
            rs.close();
            this.connector.statement.close();

        } catch (Exception e) {
            System.out.println("{Reader#getAll}" + e);
        }

        String[][] results = new String[records.size()][];
        records.toArray(results);

        return new Response(results);
    }

    public Response createOne(String name, String familyName, String gender, String status) {
        String id = null;
        try {
            PreparedStatement statement = this.connector.connection.prepareStatement(CREATE_ONE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setString(2, familyName);
            statement.setString(3, gender);
            statement.setString(4, status);
            statement.executeUpdate();

            try {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next())
                id = String.valueOf(generatedKeys.getLong(1));
            } catch (Exception exception1) {
                System.out.println("{Reader#createOne}" + exception1);
            }

        } catch (Exception exception2) {
                System.out.println("{Reader#createOne}" + exception2);
        }
        return new Response(id);
    }

    public Response updateOne(String id, String name, String familyName, String gender, String status) {
        try {
            PreparedStatement statement = this.connector.connection.prepareStatement(UPDATE_ONE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setString(2, familyName);
            statement.setString(3, gender);
            statement.setString(4, status);
            statement.setLong(5, Long.parseLong(id));
            statement.executeUpdate();

        } catch (Exception exception2) {
                System.out.println("{Reader#updateOne}" + exception2);
        }

        return new Response(id);
    }

    public Response deleteOne(String id) {
        try {
            PreparedStatement statement = this.connector.connection.prepareStatement(DELETE_ONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, Long.parseLong(id));
            statement.executeUpdate();

        } catch (Exception exception2) {
                System.out.println("{Reader#deleteOne}" + exception2);
        }

        return new Response(id);
    }

    public static void main(String[] a) {
        PostgreSql postgresql = new PostgreSql();
        Reader reader = new Reader(postgresql);

        try {
            postgresql.connect();
        } catch (Exception e) {
            System.out.println("{Reader#main}" + e);
        }

        // list all
        String[][] result = (String[][]) reader.getAll().data;
        for (String[] ele: result) {
            System.out.println(String.join("-", ele));
        }

        String id;
        // create one
        id = (String) reader.createOne("9", "9", "9", "9").data;
        System.out.println(id);

        // update one
        id = (String) reader.updateOne(id, "9", "9", "9", "9").data;
        System.out.println(id);

        id = (String) reader.deleteOne(id).data;
        System.out.println(id);
    }
}
