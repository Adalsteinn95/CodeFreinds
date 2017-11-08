package quiz.start.controller;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import quiz.start.model.User;
import quiz.start.services.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aðalsteinn Ingi Pálsson - aip7@hi.is
 *                    Geir Garðarsson - geg42@hi.is
 *                    Fannar Gauti Guðmundsson - fgg2@hi.is
 *                    Daníel Guðnason - dag27@hi.is
 *
 * Control class for user functions
 * @date october 2017
 */

@RestController
@RequestMapping("/API")
public class UserControl {

    public UserControl() {}

    private User currentUser = new User();

    private List globalErrorMessage = null;

    @Autowired
    UserService userService;

    /**
     * shows the home page
     * @return String
     */
    @RequestMapping("")
    public String home() { return "user/home"; }


    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public List errorStatus() {
        return globalErrorMessage;
    }


    /**
     * @param user
     *
     * function to handle user signups
     * @return String
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void signUp(@Valid @RequestBody User user, BindingResult errors) {

        if (!errors.hasErrors()) {
            currentUser = user;
            currentUser.setloginStatus(true);
            userService.addUser(user);
        }

        globalErrorMessage = errors.getAllErrors();

    }


    /**
     * @param user
     *
     * logs in user, will be void or boolean in the future
     * @return String
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody User user){

        if (!userService.userExists(user.getName(), user.getPass())) {
          //do something
        }

        User tmp = userService.getUser(user.getName());
        tmp.setloginStatus(true);
        userService.update(tmp);
        currentUser = tmp;

    }

    /**
     * logs out user
     * @param user
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(@RequestBody User user) {
        user.setloginStatus(false);
        userService.update(user);

        currentUser = new User();
    }

    /**
     * @return Arraylist<User>
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ArrayList<User> showUsers() {

        ArrayList<User> tmp = (ArrayList<User>) userService.getAllUsers();

        return tmp;
    }

    /**
     * @param name
     *
     * displays User object as json
     * @return
     */
    @RequestMapping(value = "/users/{userName}", method = RequestMethod.GET)
    public User showUser(@PathVariable(value = "userName") String name) {

        User tmp = userService.getUser(name);

        User u = new User(tmp.getName(), tmp.getEmail(), tmp.getPass(), tmp.getLocation(), tmp.getScore(), tmp.getLoginStatus());

        return u;
    }

    /**
     * returns the object for the current user if logged in
     * @return User
     */
    @RequestMapping(value = "/currentuser", method = RequestMethod.GET)
    public User showCurrentUser() {

        return currentUser;
    }

    @RequestMapping (value = "/alive", method = RequestMethod.GET)
    public String alive() {
        if (userService.isAlive()) {
            return "alive";
        }
        return "dead";
    }
}
