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

    void loginUser(String name, String pass);

    void logoutUser();

    boolean validateUser(String name);

    void deleteUser();

    void update();
}
