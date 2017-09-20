package quiz.start.repository;

/*
 *  Aðalsteinn Ingi Pálsson
 *  aip7@hi.is
 *
 *  Geir Garðarsson
 *  geg42@hi.is
 *
 */

import quiz.start.model.User;

/*
    A java class that collects the users, just like an repository
*/
public class UserCollection {

    /*
      one user at the moment but will be an array of Users
    */
    public User current_user;

    /*
    constructor
    */
    public UserCollection(){

    }

    /*
     * @param User
     * Function to add a new user to the collection
     */
    public void addUser(User newuser){

        current_user = newuser;
    }


    public User getUser(){
        return current_user;
    }

}
