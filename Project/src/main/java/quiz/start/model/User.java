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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String user_email;
    private String user_location;
    private boolean user_loginStatus;
    private String user_name;
    private String user_password;
    private int user_score;

    public User() {}

    /*constructor*/
    public User(long id,
                String email,
                String location,
                boolean loginStatus,
                String name,
                String password,
                int score) {

        this.user_email = email;
        this.user_location = location;
        this.user_loginStatus = loginStatus;
        this.user_name = name;
        this.user_password = password;
        this.user_score = score;
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
    public void setloginStatus() { this.user_loginStatus = !this.user_loginStatus; }
}
