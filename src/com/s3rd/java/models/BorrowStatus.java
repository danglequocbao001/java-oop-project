package com.s3rd.java.models;

import com.s3rd.java.database.PostgreSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BorrowStatus {
    PostgreSql connector;
    public static String GIVE_BACK = "Người Đọc Đã Trả";
    public static String LOST = "Người Đọc Đã Là Mất";

    public BorrowStatus(PostgreSql connector) {
        super();
        this.connector = connector;
    }

    String GET_ALL = ("SELECT borrow_statuses.id, books.name, readers.first_name || readers.last_name AS full_name, start_time, end_time, note " +
                      "FROM borrow_statuses " +
                      "LEFT JOIN readers " +
                      "	ON borrow_statuses.reader_id = readers.id " +
                      "LEFT JOIN books " +
                      "	ON borrow_statuses.book_id = books.id " +
                      "ORDER BY borrow_statuses.id");

    String CREATE_ONE = ( "INSERT INTO borrow_statuses " +
                          "       (book_id, reader_id, start_time, end_time, created_at, updated_at) " +
                          "VALUES (?      , ?        , ?         , ?       , NOW()     , NOW()     )" );

    String UPDATE_ONE = ( "UPDATE borrow_statuses " +
                          "SET book_id = ?, " +
                          "    reader_id = ?, " +
                          "    start_time = ?, " +
                          "    end_time = ?, " +
                          "    updated_at = NOW() " +
                          "WHERE id = ?" );

    String UPDATE_TIME_ONE = ( "UPDATE borrow_statuses " +
                               "SET end_time = NOW(), " +
                               "    note = ? " +
                               "WHERE id = ?" );

    String LOST_BOOK = ( "UPDATE borrow_statuses " +
                         "SET note = ? " +
                         "WHERE id = ?" );

    String DELETE_ONE = "DELETE FROM borrow_statuses WHERE id = ?";

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
                    rs.getString("full_name"),
                    rs.getObject("start_time").toString(),
                    rs.getObject("end_time") != null ? rs.getObject("end_time").toString() : "",
                    rs.getString("note") != null ? rs.getString("note") : ""
                });
                index += 1;
            }
            rs.close();
            this.connector.statement.close();

        } catch (Exception e) {
            System.out.println("{BorrowStatus#getAll}" + e);
        }

        String[][] results = new String[records.size()][];
        records.toArray(results);

        return new Response(results);
    }

    public Response createOne(String book_id, String reader_id, LocalDateTime start_time, LocalDateTime end_time) {
        String id = null;
        try {
            PreparedStatement statement = this.connector.connection.prepareStatement(CREATE_ONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, Long.parseLong(book_id));
            statement.setLong(2, Long.parseLong(reader_id));
            statement.setObject(3, start_time);
            statement.setObject(4, end_time);
            statement.executeUpdate();

            try {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next())
                id = String.valueOf(generatedKeys.getLong(1));
            } catch (Exception exception1) {
                System.out.println("{BorrowStatus#createOne}" + exception1);
            }

        } catch (Exception exception2) {
                System.out.println("{BorrowStatus#createOne}" + exception2);
        }
        return new Response(id);
    }

    public Response updateOne(String id, String book_id, String reader_id, LocalDateTime start_time, LocalDateTime end_time) {
        try {
            PreparedStatement statement = this.connector.connection.prepareStatement(UPDATE_ONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, Long.parseLong(book_id));
            statement.setLong(2, Long.parseLong(reader_id));
            statement.setObject(3, start_time);
            statement.setObject(4, end_time);
            statement.setLong(5, Long.parseLong(id));
            statement.executeUpdate();

        } catch (Exception exception2) {
            System.out.println("{BorrowStatus#updateOne}" + exception2);
        }

        return new Response(id);
    }

    public Response updateTimeOne(String id) {
        try {
            PreparedStatement statement = this.connector.connection.prepareStatement(UPDATE_TIME_ONE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, BorrowStatus.GIVE_BACK);
            statement.setLong(2, Long.parseLong(id));
            statement.executeUpdate();

        } catch (Exception exception2) {
            System.out.println("{BorrowStatus#updateTimeOne}" + exception2);
        }

        return new Response(id);
    }

    public Response lostBook(String id) {
        try {
            PreparedStatement statement = this.connector.connection.prepareStatement(LOST_BOOK, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, BorrowStatus.LOST);
            statement.setLong(2, Long.parseLong(id));
            statement.executeUpdate();

        } catch (Exception exception2) {
            System.out.println("{BorrowStatus#updateTimeOne}" + exception2);
        }

        return new Response(id);
    }

    public Response deleteOne(String id) {
        try {
            PreparedStatement statement = this.connector.connection.prepareStatement(DELETE_ONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, Long.parseLong(id));
            statement.executeUpdate();

        } catch (Exception exception2) {
            System.out.println("{BorrowStatus#deleteOne}" + exception2);
        }

        return new Response(id);
    }

    public static void main(String[] a) {
        PostgreSql postgresql = new PostgreSql();
        BorrowStatus borrow_statuses = new BorrowStatus(postgresql);

        try {
            postgresql.connect();
        } catch (Exception e) {
            System.out.println("{BorrowStatus#main}" + e);
        }

        String id;
        // create one
        id = (String) borrow_statuses.createOne("1", "1", LocalDateTime.now(), LocalDateTime.now()).data;
        System.out.println(id);

        // list all
        String[][] result;
        result = (String[][]) borrow_statuses.getAll().data;
        for (String[] ele: result) {
            System.out.println(String.join("\t\t\t", ele));
        }

        // update one
        borrow_statuses.updateTimeOne("5");
        id = (String) borrow_statuses.updateTimeOne(id).data;
        System.out.println(id);

        result = (String[][]) borrow_statuses.getAll().data;
        for (String[] ele: result) {
            System.out.println(String.join("\t\t\t", ele));
        }

        id = (String) borrow_statuses.deleteOne(id).data;
        System.out.println(id);

        result = (String[][]) borrow_statuses.getAll().data;
        for (String[] ele: result) {
            System.out.println(String.join("\t\t\t", ele));
        }
    }
}
