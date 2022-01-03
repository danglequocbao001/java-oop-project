package com.s3rd.java.models;

import com.s3rd.java.database.PostgreSql;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Book {
	PostgreSql connector;

	public Book(PostgreSql connector) {
		super();
		this.connector = connector;
	}
	
	public String[][] getAll() {
        ArrayList<String[]> records = new ArrayList<String[]>();

        try {
        	this.connector.statement = this.connector.connection.createStatement();
        	ResultSet rs = this.connector.statement.executeQuery("select * from books");
        	
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

        } catch (Exception e) {}

        String[][] results = new String[records.size()][];
        records.toArray(results);

		return results;
	}
	
	public static void main(String[] a) {
        PostgreSql postgresql = new PostgreSql();
        Book book = new Book(postgresql);

        try {
        	postgresql.connect();
        } catch (Exception e) {}

        String[][] result = book.getAll();
        for (String[] ele: result) {
        	System.out.println(String.join("-", ele));
        }
	}
}