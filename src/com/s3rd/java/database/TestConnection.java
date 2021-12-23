package com.s3rd.java.database;

import java.sql.SQLException;

public class TestConnection {
	public static void main(String[] args) {
		PostgreSql voi = new PostgreSql();
		try {
			voi.connect();
			System.out.println("connect");
		} catch (SQLException e) {
			System.out.println("can not connect to database");
		}
	}
}
