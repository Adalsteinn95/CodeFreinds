package quiz.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.start.model.User;

import java.util.List;

/**
 * @author Geir Garðarsson - geg42@hi.is
 * @date october 2017
 *
 * User repository interface
 */

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User save(User u);

}


