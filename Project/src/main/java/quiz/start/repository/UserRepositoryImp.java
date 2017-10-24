package quiz.start.repository;

/**
 * @author Geir Gardarsson - geg42@hi.is
 *         Daniel Gudnason - dag27@hi.is
 * @date october 2017
 */

import org.springframework.stereotype.Repository;
import quiz.start.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImp {

    private final List<User> users;


    public UserRepositoryImp() {
        this.users = new ArrayList<User>();
    }


}
