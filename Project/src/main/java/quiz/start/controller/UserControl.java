package quiz.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import quiz.start.model.User;
import quiz.start.services.UserService;
import javax.validation.Valid;
import java.util.ArrayList;

/**
 * @author Aðalsteinn Ingi Pálsson - aip7@hi.is
 *                    Geir Garðarsson - geg42@hi.is
 *                    Fannar Gauti Guðmundsson - fgg2@hi.is
 *                    Daníel Guðnason - dag27@hi.is
 *
 * User control API
 *
 * @date october 2017
 */

@RestController
@RequestMapping("/API")
public class UserControl {

    /**
     * Constructor
     */
    public UserControl() {}

    /**
     * Current logged-in user
     */
    private User currentUser = new User();

    /**
     * Error message for user-related errors.
     * Hosted on /API/error
     */
    private String globalErrorMessage = null;

    /**
     * Service for handling user database actions
     */
    @Autowired
    UserService userService;

    /**
     * Password encoder constructor
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * PasswordEncoder
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Nothing displayed on the url /API
     * @return String
     */
    @RequestMapping("")
    public String home() {
        return "";
    }


    /**
     * Handler for the frontend to check for a user related error
     * @return String
     */
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorStatus() {
        return globalErrorMessage;
    }


    /**
     * @param user
     * @param errors
     *
     * Function that handles and user signups.
     * Calls userService for validation and updates /API/error accordingly.
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void signUp(@Valid @RequestBody User user, BindingResult errors) {

        if (!errors.hasErrors()) {
            if (!userService.validateName(user.getName())) {
                globalErrorMessage = "Notendanafn er tekið";
            }
            else if (!userService.validateEmail(user.getEmail())) {
                globalErrorMessage = "Netfang er í notkun";
            }
            else {
                currentUser = user;
                currentUser.setloginStatus(true);
                currentUser.setPass(passwordEncoder.encode(currentUser.getPass()));
                userService.addUser(user);
                globalErrorMessage = "";
            }
        } else {
            globalErrorMessage = errors.getAllErrors().get(0).getDefaultMessage();
        }
    }


    /**
     * @param user
     * Function to handle user logins. Calls userService for validation
     * and updates /API/error accordingly.
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody User user){

        if (userService.userExists(user.getName(), user.getPass())) {
            User tmp = userService.getUser(user.getName());
            tmp.setloginStatus(true);
            userService.update(tmp);
            currentUser = tmp;
            globalErrorMessage = "";
        }
        else {
            globalErrorMessage = "Notendanafn eða lykilorð er rangt";
        }
    }

    /**
     * @param user
     *
     * Function to log out active user. Updates currentUser to a empty User.
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(@RequestBody User user) {

        user.setloginStatus(false);
        userService.update(user);
        currentUser = new User();
    }

    /**
     * Displays all users and userdata
     *
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
     * Displays the User object of a given user
     * @return User
     */
    @RequestMapping(value = "/users/{userName}", method = RequestMethod.GET)
    public User showUser(@PathVariable(value = "userName") String name) {

        User tmp = userService.getUser(name);
        User u = new User(tmp.getName(), tmp.getEmail(), tmp.getPass(), tmp.getLocation(), tmp.getScore(), tmp.getLoginStatus());
        return u;
    }


    /**
     * Returns the User object for the current user if logged in
     * @return User
     */
     
    @RequestMapping(value = "/currentuser", method = RequestMethod.GET)
    public User showCurrentUser() {

        return currentUser;
    }

    /**
     * @param newScore
     *
     * Updates score in the database if the new score is higher
     */
    @RequestMapping(value = "/updateScore", method = RequestMethod.POST)
    public void updateScore(@RequestBody String newScore) {

        int intScore = Integer.parseInt(newScore.substring(0, newScore.length() - 1));

        if (intScore > currentUser.getScore()) {
          currentUser.setScore(intScore);
        }
        userService.update(currentUser);
    }
}
