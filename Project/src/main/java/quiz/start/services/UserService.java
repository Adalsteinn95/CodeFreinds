package quiz.start.services;

/**
 * @author Geir Gardarsson - geg42@hi.is
 * @date october 2017
 */

import quiz.start.model.User;

import java.util.List;

public interface UserService {

    /**
     * add a new user to the db
     * @param u
     */
    void addUser(User u);

    /**
     * gets list with all users
     * @return List<User>
     */
    List<User> getAllUsers();

    /**
     * @param name
     * @param pass
     *
     * handles user logins
     * @return boolean
     */
    boolean userExists(String name, String pass);

    /**
     * @param name
     *
     * checks username, returns false if user
     * exists, true otherwise
     * @return boolean
     */
    boolean validateName(String name);

    /**
     * TODO
     * destroys user
     * @param name
     */
    void deleteUser(String name);

    /**
     * gets single user by name
     * @param name
     * @return User
     */
    User getUser(String name);

    /**
     * updates user
     * @param u
     * @return
     */
    void update(User u);

    boolean isAlive();
}

