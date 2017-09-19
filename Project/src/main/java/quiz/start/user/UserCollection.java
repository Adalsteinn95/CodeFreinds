package quiz.start.user;

/*
 *  Aðalsteinn Ingi Pálsson
 *  aip7@hi.is
 *
 *  Geir Garðarsson
 *  geg42@hi.is
 *
 *
 *
 */
public class UserCollection {

    public User current_user;

    public UserCollection(){

    }

    public void addUser(User newuser){
        current_user = newuser;
    }

}
