package com.nulp.pp.users;

import java.sql.*;

public class King {
    private static String name;
    private static long wealth = 1000000;
    private static long citizens;

    private static final String url = "jdbc:postgresql://localhost:5432/Knights";
    private static final String user = "postgres";
    private static final String password = "12345";

    private static Connection connection;

    public static boolean isPossibleToCreateBatallions(int numOfBatallions) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostgreSQL");
            Statement statement = connection.createStatement();

            String sql = "SELECT COUNT(*) FROM knights2 WHERE knight_type = 1";
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            int numOfInfantrymans = rs.getInt(1);

            sql = "SELECT COUNT(*) FROM knights2 WHERE knight_type = 2";
            rs = statement.executeQuery(sql);
            rs.next();
            int numOfBowmans = rs.getInt(1);

            sql = "SELECT COUNT(*) FROM knights2 WHERE knight_type = 3";
            rs = statement.executeQuery(sql);
            rs.next();
            int numOfHorsemans = rs.getInt(1);

            sql = "SELECT COUNT(*) FROM knights2 WHERE knight_type = 4";
            rs = statement.executeQuery(sql);
            rs.next();
            int numOfCommanders = rs.getInt(1);
            if ((numOfCommanders >= 1 * numOfBatallions)
                    && (numOfInfantrymans >= 100 * numOfBatallions)
                    && (numOfHorsemans >= 50 * numOfBatallions)
                    && (numOfBowmans >= 49 * numOfBatallions))
                return true;
            return false;
        } catch (SQLException e) {
            System.out.println("Error in connecting to PosgreSQL server");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return false;
    }


    public static boolean isPossibleToCreateSquad(int numOfSquads) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostgreSQL");
            Statement statement = connection.createStatement();

            String sql = "SELECT COUNT(*) FROM knights2 WHERE knight_type = 3";
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            int numOfHorsemans = rs.getInt(1);

            sql = "SELECT COUNT(*) FROM knights2 WHERE knight_type = 4";
            rs = statement.executeQuery(sql);
            rs.next();
            int numOfCommanders = rs.getInt(1);
            if ((numOfCommanders >= 1 * numOfSquads)
                    && (numOfHorsemans >= 50 * numOfSquads))
                return true;
            return false;
        } catch (SQLException e) {
            System.out.println("Error in connecting to PosgreSQL server");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return false;
    }
}
