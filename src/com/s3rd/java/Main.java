package com.s3rd.java;

import com.s3rd.java.database.PostgreSql;
import com.s3rd.java.graphic.Graphic;

public class Main {
    public static void main(String[] args) {
        Graphic program = new Graphic();
        PostgreSql postgresql = new PostgreSql();

        try {
            postgresql.connect();
            program.loadModels(postgresql);
            program.mainMenu();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
