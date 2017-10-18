package quiz.start.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Daníel Guðnason
 * dag27@hi.is
 *
 * Geir Garðarsson
 * geg42@hi.is
 *
 */

public class SQLUser {

    String url;
    String userName;
    String DBpassword;
    String dbName;
    Connection con;
    public SQLUser(){
        url = "jdbc:postgresql://database.cs4i2xywnni0.eu-west-1.rds.amazonaws.com:5432/";
        userName = "Codefriends";
        DBpassword = "123456789";
        dbName = "Database1";

    }
    public void newUser(String name, String Pass, String email, int score, String location) throws ClassNotFoundException{

        try
        {

            con = DriverManager.getConnection(url + dbName, userName, DBpassword);
            //con = DriverManager.getConnection(application.prperties.spring.datasource.url, userName, DBpassword);
            String SQL = "INSERT INTO Users VALUES (?,?,?,?,?);";
            PreparedStatement stmt =  con.prepareStatement(SQL);
            stmt.setString(1, name);
            stmt.setString(2, Pass);
            stmt.setString(3, email);
            stmt.setInt(4, score);
            stmt.setString(5, location);
            stmt.executeUpdate();

            con.close();
        }
        catch(Exception e)
        {

            System.out.println("Error  " + email + "     " + e.getMessage());

        }
    }
    public ResultSet getUserInfo(String email, String password) throws SQLException {
        try{
            con = DriverManager.getConnection(url + dbName, userName, DBpassword);
            String SQL = "SELECT \"ID\", \"name\", \"pass\", \"email\", \"score\", \"location\" FROM users WHERE (\"email\" = ? AND \"password\" = ?);";
            PreparedStatement stmt =  con.prepareStatement(SQL);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs);
            con.close();
            return rs;
        }
        catch(Exception e)
        {
            System.out.println(e);
            con.close();
            return null;
        }


    }
    public boolean isUser(String email, String password) {
        try
        {
            con = DriverManager.getConnection(url + dbName, userName, DBpassword);
            String SQL = "SELECT \"password\" FROM users WHERE \"email\" = (?);";
            PreparedStatement isUserStmt = con.prepareStatement(SQL);
            isUserStmt.setString(1, email);
            ResultSet rs = isUserStmt.executeQuery();
            while(rs.next()){
                if((rs.getString(1).equals(password))){
                    con.close();
                    return true;
                }
            }
            con.close();
            return false;


        }
        catch(Exception e)
        {
            System.out.println("Error " + e.getMessage());
            return false;
        }
    }

    public void deleteUser(String name, String email, String pass) {
        try
        {
            con = DriverManager.getConnection(url + dbName, userName, DBpassword);
            String SQLusers = "DELETE FROM Users WHERE (\"Name\" = ? AND \"Email\" = ? AND \"Pass\" = ?)";
            // test dót:String SQLusers = "DELETE FROM Users WHERE \"Name\" = 'delete';";
            System.out.println(SQLusers);
            PreparedStatement deleteUserUsers = con.prepareStatement(SQLusers);
            deleteUserUsers.setString(1,name);
            deleteUserUsers.setString(2,email);
            deleteUserUsers.setString(3,pass);
            //ResultSet rs1 = deleteUserUsers.executeQuery();
            deleteUserUsers.executeUpdate();
            con.close();
        }
        catch(Exception e)
        {

            System.out.println("Error " + e.getMessage());

        }

    }

    public void updatescore(String name, String email, int score){
        try
        {
            con = DriverManager.getConnection(url + dbName, userName, DBpassword);
            String SQLprevscore = "SELECT \"Score\" FROM Users WHERE (\"Name\" = ? AND \"Email\" = ?)";
            PreparedStatement oldscore =  con.prepareStatement(SQLprevscore);
            oldscore.setString(1,name);
            oldscore.setString(2,email);
            System.out.println(oldscore);
            ResultSet rs1 = oldscore.executeQuery();
            rs1.next();
            int prevScore = rs1.getInt(1);

            //int prevScore = 0;

            if( score > prevScore) {
                String SQLnewscore = "UPDATE Users SET \"Score\" = ? WHERE (\"Name\" = ? AND \"Email\" = ?)";
                PreparedStatement updatescore = con.prepareStatement(SQLnewscore);
                updatescore.setInt(1,score);
                updatescore.setString(2,name);
                updatescore.setString(3,email);
                updatescore.executeUpdate();

            }
            con.close();

        }
        catch(Exception e)
        {
            System.out.println("upps " + e);
        }
    }

    public ResultSet extractAllUsers() throws SQLException {
        try{
            con = DriverManager.getConnection(url + dbName, userName, DBpassword);

            //Alternative resultset with nonconfidential data
            //String SQL = "SELECT \"Name\", \"Score\", \"Location\" FROM USERS";

            String SQL = "SELECT * FROM USERS";
            PreparedStatement stmt =  con.prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();
            con.close();
            return rs;
        }
        catch(Exception e)
        {
            System.out.println(e);
            con.close();
            return null;
        }
    }


}
