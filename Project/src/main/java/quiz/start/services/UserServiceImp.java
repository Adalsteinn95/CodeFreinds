package quiz.start.services;

/**
 * @author Geir Gardarsson - geg42@hi.is
 * @date october 2017
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.start.model.User;
import quiz.start.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User u) {
        List<User> tmp = userRepository.findAll();

        tmp.add(u);

        userRepository.save(tmp);


    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
<<<<<<< HEAD
    public boolean userExists(String name, String pass) {

        if (validateName(name)) { return false; }

        User tmp = userRepository.getOne(name);
=======
    public void loginUser(String name, String pass) {
>>>>>>> parent of 3b61c60... JPA connection og base fyrir API komid.

    }

    @Override
    public void logoutUser() {

    }

    @Override
    public boolean validateUser(String name) {
        return false;
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void update() {
       // userRepository.updateRepository();
    }
}
