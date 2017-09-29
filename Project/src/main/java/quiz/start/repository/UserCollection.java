package quiz.start.repository;

/*
 *  Aðalsteinn Ingi Pálsson
 *  aip7@hi.is
 *
 *  Geir Garðarsson
 *  geg42@hi.is
 *
 *  Daníel Guðnason
 *  dag**@hi.is
 */

import quiz.start.model.User;
import quiz.start.repository.SQLUser;

/*
    A java class that collects the users, just like an repository
*/
public class UserCollection {

    //one user at the moment but will be an array of Users
    public User current_user;
    public SQLUser SQL;

    /*
    constructor
    */
    public UserCollection(){
        SQL = new SQLUser();
    }

    /*
     * @param User
     * Function to add a new user to the collection
     */
    public void addUser(User newuser) {

        current_user = newuser;
        //SQL.newUser(current_user.getName(),current_user.getPass(),current_user.getEmail(), 100, "Reykjavík");
        try {
            SQL.newUser(66, current_user.getName(),current_user.getPass(),current_user.getEmail(), 100, "Reykjavík");
            //SQL.newUser("test1","test12", "eamil@enaln1", 45, "Reykjavík");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void deleteUser(User newuser) throws ClassNotFoundException {
        current_user = newuser;
        System.out.println("ping");
        SQL.deleteUser(current_user.getName(),current_user.getPass(),current_user.getEmail());
    }


    public User getUser(){
        return current_user;
    }

}
