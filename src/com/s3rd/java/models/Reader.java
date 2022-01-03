package com.s3rd.java.models;

import com.s3rd.java.database.PostgreSql;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Reader {
	PostgreSql connector;
	String GET_ALL = "SELECT * FROM readers";

	public Reader(PostgreSql connector) {
		super();
		this.connector = connector;
	}
	
	public String[][] getAll() {
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

        } catch (Exception e) {}

        String[][] results = new String[records.size()][];
        records.toArray(results);

		return results;
	}

	public static void main(String[] a) {
        PostgreSql postgresql = new PostgreSql();
        Reader reader = new Reader(postgresql);

        try {
        	postgresql.connect();
        } catch (Exception e) {}

        String[][] result = reader.getAll();
        for (String[] ele: result) {
        	System.out.println(String.join("-", ele));
        }
	}
}