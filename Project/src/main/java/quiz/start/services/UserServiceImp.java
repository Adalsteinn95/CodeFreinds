package quiz.start.services;

/**
 * @author Geir Gardarsson - geg42@hi.is
 *         Daníel Guðnason - dag27@hi.is
 * @date october 2017
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import quiz.start.model.User;
import quiz.start.repository.UserRepository;
import java.util.Iterator;
import java.util.List;

/**
 * Implementation of userService.
 * See userService.java for documentation
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

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
    public boolean userExists(String name, String pass) {

        if (validateName(name)) { return false; }

        User tmp = userRepository.getOne(name);

        if (passwordEncoder.matches(pass, tmp.getPass())) { return true; }

        return false;
    }

    @Override
    public boolean validateName(String name) {

        List<User> tmp = userRepository.findAll();

        Iterator<User> nameIterator = tmp.iterator();
        while (nameIterator.hasNext()) {
            User u = nameIterator.next();
            if (name.equals(u.getName())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validateEmail(String email) {

        List<User> tmp = userRepository.findAll();

        Iterator<User> mailIterator = tmp.iterator();
        while (mailIterator.hasNext()) {
            User u = mailIterator.next();
            if (email.equals(u.getEmail())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void deleteUser(String name) {

    }

    @Override
    public User getUser(String name) {
        return userRepository.getOne(name);
    }

    @Override
    public void update(User u) {
        userRepository.save(u);
    }

}
