package com.assignment;

import java.sql.*;
import java.util.*;

import com.assignment.FeyisayoCompetitor.Level;


/**
 * This is a class for interacting with the mysql database.
 */
public class MysqlCli {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/competition";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    static {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setup() {
        
    }


    public static void addCompetitor(FeyisayoCompetitor comp) {
        String query1 = "INSERT INTO competitors (id, name, level) VALUES (?, ?, ?)";
        String query2 = "INSERT INTO scores (id, score) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement statement1 = connection.prepareStatement(query1);
            PreparedStatement statement2 = connection.prepareStatement(query2)) {
            statement1.setInt(1, comp.getCompetitorID());
            statement1.setString(2, comp.getCompetitorName());
            statement1.setString(3, comp.getCompetitorLevel().toString());
            statement1.executeUpdate();
            for (Integer score : comp.getScores()) {
                statement2.setInt(1, comp.getCompetitorID());
                statement2.setInt(2, score);
                statement2.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static FeyisayoCompetitor getCompetitor(int id) {
        String query1 = "SELECT * FROM competitors WHERE id = ?";
        String query2 = "SELECT * FROM scores WHERE id = ?";
        FeyisayoCompetitor comp = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement statement1 = connection.prepareStatement(query1);
            PreparedStatement statement2 = connection.prepareStatement(query2)) {
            statement1.setInt(1, id);
            ResultSet resultSet1 = statement1.executeQuery();
            statement2.setInt(1, id);
            ResultSet resultSet2 = statement2.executeQuery();
            if (!resultSet1.next()) {
                return null;
            }
            int question = resultSet1.getInt("id");
            String name = resultSet1.getString("name");
            Level level = Level.valueOf(resultSet1.getString("level"));
            comp = new FeyisayoCompetitor(question, name, level);
            ArrayList<Integer> scores = new ArrayList<>();               
            while (resultSet2.next()) {
                int score = resultSet2.getInt("score");
                scores.add(score);
            }
            comp.setScores(scores);
            return comp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comp;
    }
    
    public static List<FeyisayoCompetitor> getAllCompetitors() {
        String query1 = "SELECT * FROM competitors";
        String query2 = "SELECT * FROM scores WHERE id = ?";
        FeyisayoCompetitor comp = null;
        LinkedList<FeyisayoCompetitor> competitors = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement statement1 = connection.prepareStatement(query1);
            PreparedStatement statement2 = connection.prepareStatement(query2)) {
            ResultSet resultSet1 = statement1.executeQuery();
            while (resultSet1.next()) {
                int id = resultSet1.getInt("id");
                String name = resultSet1.getString("name");
                Level level = Level.valueOf(resultSet1.getString("level"));
                comp = new FeyisayoCompetitor(id, name, level);
                ArrayList<Integer> scores = new ArrayList<>(); 
                statement2.setInt(1, id);
                ResultSet resultSet2 = statement2.executeQuery();              
                while (resultSet2.next()) {
                    int score = resultSet2.getInt("score");
                    scores.add(score);
                }
                comp.setScores(scores);
                competitors.add(comp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return competitors;
    }
}