package quiz.start.model;

import javax.persistence.*;

/**
 * @authors Aðalsteinn Ingi Pálsson - aip@hi.is
 *          Geir Garðarsson - geg42@hi.is
 *
 * @date october 2017
 *
 * model class for users
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    private String user_name;
    @Column(unique = true)
    private String user_email;
    private String user_password;
    private String user_location;
    private int user_score;
    private boolean user_loginStatus;

    public User() {}

    /*constructor*/
    public User(String name,
                String email,
                String password,
                String location,
                int score,
                boolean loginStatus) {

        this.user_name = name;
        this.user_email = email;
        this.user_password = password;
        this.user_location = location;
        this.user_score = score;
        this.user_loginStatus = loginStatus;
    }

    /*get and setters*/
    public String getName(){ return this.user_name; }
    public String getPass(){
        return this.user_password;
    }
    public String getEmail() {
        return this.user_email;
    }
    public int getScore() { return this.user_score; }
    public String getLocation() { return this.user_location; }
    public boolean getLoginStatus() { return this.user_loginStatus; }

    public void setName(String name) {
         this.user_name = name;
     }
    public void setPass(String pass) {
         this.user_password = pass;
     }
    public void setEmail(String email) {
        this.user_email = email;
    }
    public void setLocation(String location) { this.user_location = location; }
    public void setloginStatus(boolean b) { this.user_loginStatus = b; }
}
