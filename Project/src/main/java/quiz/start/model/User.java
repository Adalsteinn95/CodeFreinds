package quiz.start.model;
/*
 * Aðalsteinn Ingi Pálsson
 * aip7@hi.is
 *
 * Geir Garðarsson
 * geg42@hi.is
 *
 *
 */

import java.util.Hashtable;

/*
 class for users
 */
public class User {

    private String user_name;
    private String user_password;
    private String user_email;
    private int user_currentScore;
    private int user_highScore;
    private String user_location;
    private boolean user_loginStatus;

    /*constructor*/
    public User(String name,
                String password,
                String email,
                int score,
                int highScore,
                String location,
                boolean loginStatus) {

          user_name = name;
          user_password = password;
          user_email = email;
          user_currentScore = score;
          user_highScore = highScore;
          user_location = location;
          user_loginStatus = loginStatus;
    }

    /*get and setters*/
    public String getName(){
        return user_name;
    }
    public String getPass(){
        return user_password;
    }
    public String getEmail() {
        return user_email;
    }
    public int getScore() { return user_currentScore; }
    public int getHighScore() { return user_highScore; }
    public String getLocation() { return user_location; }
    public boolean getLoginStatus() { return user_loginStatus; }

    public void setName(String name) {
         user_name = name;
     }
    public void setPass(String pass) {
         user_password = pass;
     }
    public void setEmail(String email) {
        user_email = email;
    }
    public void incScore() { user_currentScore++; }
    public void setHighscore(int newHiScore) { user_highScore = newHiScore; }
    public void setLocation(String location) { user_location = location; }
    public void setloginStatus() { user_loginStatus = !user_loginStatus; }
}
