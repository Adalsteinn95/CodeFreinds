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

    public User(String name, String password){
          user_name = name;
          user_password = password;
    }


    public String getName(){
        return user_name;
    }

    public String getPass(){
        return user_password;
    }

}
