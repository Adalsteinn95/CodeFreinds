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
<<<<<<< HEAD
    private String userName;
    @Column(unique = true)
    private String email;
    private String password;
    private String location;
    private int score;
    private boolean loginStatus;
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String user_email;
    private String user_location;
    private boolean user_loginStatus;
    private String user_name;
    private String user_password;
    private int user_score;
>>>>>>> parent of 3b61c60... JPA connection og base fyrir API komid.

    public User() {}

    /*constructor*/
    public User(long id,
                String email,
                String location,
                boolean loginStatus,
                String name,
                String password,
                int score) {

<<<<<<< HEAD
        this.userName = name;
        this.email = email;
        this.password = password;
        this.location = location;
        this.score = score;
        this.loginStatus = loginStatus;
=======
        this.user_email = email;
        this.user_location = location;
        this.user_loginStatus = loginStatus;
        this.user_name = name;
        this.user_password = password;
        this.user_score = score;
>>>>>>> parent of 3b61c60... JPA connection og base fyrir API komid.
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
<<<<<<< HEAD
    public void setLocation(String location) { this.location = location; }
    public void setloginStatus(boolean b) { this.loginStatus = b; }
=======
    public void setLocation(String location) { this.user_location = location; }
    public void setloginStatus() { this.user_loginStatus = !this.user_loginStatus; }
>>>>>>> parent of 3b61c60... JPA connection og base fyrir API komid.
}
