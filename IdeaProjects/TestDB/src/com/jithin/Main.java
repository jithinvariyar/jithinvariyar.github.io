package com.jithin;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "testJava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/home/jithin/Documents/IdeaProjects/TestDB/" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";
    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE " + TABLE_CONTACTS + "(" + COLUMN_NAME + " TEXT, " + COLUMN_PHONE + " INTEGER, " + COLUMN_EMAIL + " TEXT)");
            statement.executeUpdate("INSERT INTO " + TABLE_CONTACTS +
                    " VALUES ('Jithin',1234,'jithin@gmail.com')," +
                    "('Jishnu',2345,'jishnu@gmail.com')," +
                    "('Raji',3456,'Raji@gmail.com')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while (resultSet.next()){
                System.out.println(resultSet.getRow());
                System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2) + " " +resultSet.getString(3));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
