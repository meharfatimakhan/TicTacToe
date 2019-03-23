/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Dell
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class modelClass {

    Connection myConObj;
    Statement myStatObj;

    modelClass() 
    {
        try {
            String s = "jdbc:derby://localhost:1527/ticTacToe";
            myConObj = DriverManager.getConnection(s, "mehar", "12345");

            myStatObj = myConObj.createStatement();

        } catch (Exception e) {
            System.out.println(e + " EXCEPTION IN CONNECTING TO DATABASE!");
        }
    }

    ArrayList<controllerClass> LoadAllUsers() {
        ArrayList<controllerClass> userRecord = new ArrayList<>();
        try {
            ResultSet myResultObj = myStatObj.executeQuery("SELECT * FROM SCORES");
            while (myResultObj.next()) {

                String username;
                String score;

                username = myResultObj.getString(1);
                score = myResultObj.getString(2);

                System.out.println(username + " " + score);
                controllerClass newUserScoreEntry = new controllerClass(username, score);
                userRecord.add(newUserScoreEntry);

            }

        } catch (Exception e) {
            System.out.println(e + " EXCEPTION IN LOADING ALL USERS");
        }

        return userRecord;
    }

    void addNewUser(String user, String win) {

        try {
            myStatObj.executeUpdate("Insert into scores (name, wins) values('" + user + "','" + win + "')");

        } catch (Exception e) {
            System.out.println(e + " Exception in adding new users");

        }

    }
    
     void setScore(String username, String updatedScore) {

        try {
            int i = myStatObj.executeUpdate("UPDATE SCORES SET WINS='" + updatedScore + "'Where name='" + username + "'");//  "' AND '" + updatedScore +"' > bestscore'");
        } catch (Exception e) {
            System.out.println(e+" EXCEPTION IN SETSCORE FUNCTION!");
        }
    }

    String userExistsOrNot(String username) {
        String USER = "";
        try {
            ResultSet myResultObj = myStatObj.executeQuery("SELECT NAME FROM SCORES WHERE name='" + username + "'");
            while (myResultObj.next()) {
                USER = myResultObj.getString(1);
            }
            return USER;

        } catch (Exception e) {
            System.out.println(e + " Exception in adding new users");
            return "";

        }
    }

     String getCurrentScore(String username) {
        String wins = "0";
        try {
            ResultSet myResultObj = myStatObj.executeQuery("SELECT wins FROM SCORES WHERE name='" + username + "'");
            while (myResultObj.next()) {
                wins = myResultObj.getString(1);
            }
            return wins;

        } catch (Exception e) {
            System.out.println(e + " Exception in adding new users");
            return "0";

        }
    }
    void closeConnection() {
        try {
            myConObj.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
