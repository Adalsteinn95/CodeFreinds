package quiz.start.services;

/**
 * @author Geir Gardarsson - geg42@hi.is
 * @date october 2017
 */

import quiz.start.model.User;

import java.util.List;

public interface UserService {

    void addUser(User u);

    List<User> getAllUsers();

<<<<<<< HEAD
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
=======
    void loginUser(String name, String pass);

    void logoutUser();

    boolean validateUser(String name);

    void deleteUser();

    void update();
>>>>>>> parent of 3b61c60... JPA connection og base fyrir API komid.
}
