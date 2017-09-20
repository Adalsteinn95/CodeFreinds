package quiz.start.user;
/*
 * Aðalsteinn Ingi Pálsson
 * aip7@hi.is
 *
 * Geir Garðarsson
 * geg42@hi.is
 *
 *
 */
public class User {

    private String user_name;
    private String user_password;
    private String user_email;

    public User(String name, String password,String email){
          user_name = name;
          user_password = password;
          user_email = email;
    }


    public String getName(){
        return user_name;
    }

    public String getPass(){
        return user_password;
    }

    public String getEmail() {
        return user_email;
    }

    public void setEmail(String email) {
        user_email = email;
    }

    public void setPass(String pass) {
        user_password = pass;
    }

    public void setName(String name) {
        user_name = name;
    }
}