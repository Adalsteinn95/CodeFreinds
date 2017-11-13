package quiz.start.model;

import javax.persistence.*;
import javax.validation.constraints.*;

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
    @Column(unique = true)
    @Pattern(regexp = ".{4,}", message = "Notendanafn verður að vera a.m.k. 4 stafir")
    private String userName;
    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9+._-]+@[a-z]+\\.[a-z]+$", message = "Netfang verður að vera á réttu formi")
    private String email;
    @Pattern(regexp = ".{6,}", message = "Lykilorð verður að vera a.m.k 6 stafir")
    private String password;
    private String location;
    private int score;
    private boolean loginStatus;

    public User() {}

    /*constructor*/
    public User(String name,
                String email,
                String password,
                String location,
                int score,
                boolean loginStatus) {

        this.userName = name;
        this.email = email;
        this.password = password;
        this.location = location;
        this.score = score;
        this.loginStatus = loginStatus;
    }

    /*get and setters*/
    public String getName(){ return this.userName; }
    public String getPass(){
        return this.password;
    }
    public String getEmail() {
        return this.email;
    }
    public int getScore() { return this.score; }
    public String getLocation() { return this.location; }
    public boolean getLoginStatus() { return this.loginStatus; }

    public void setName(String name) {
         this.userName = name;
     }
    public void setPass(String pass) {
         this.password = pass;
     }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setLocation(String location) { this.location = location; }
    public void setloginStatus(boolean b) { this.loginStatus = b; }
    public void setScore(int s) { this.score = s; }
}
